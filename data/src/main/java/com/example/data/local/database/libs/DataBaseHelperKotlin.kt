package com.example.pokemon.utils.database.libs

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

private val DB_NAME = "pokemon.db" // Database name
private var DB_PATH = ""

class DataBaseHelperKotlin(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {

    private val TAG = "DataBaseHelper" // Tag just for the LogCat window

    //destination path (location) of our database on device

    private var mDataBase: SQLiteDatabase? = null
    private var mContext: Context? = context

    fun getDataBase(): SQLiteDatabase? {
        return mDataBase
    }

    init {
        DB_PATH = context.applicationInfo.dataDir + "/databases/"
    }

//    fun DataBaseHelperKotlin(context: Context) {
//        super(context, DB_NAME, null, 1) // 1? Its database Version
//        DB_PATH = context.applicationInfo.dataDir + "/databases/"
//        mContext = context
//    }

    @Throws(IOException::class)
    fun createDataBase() {
        //If the database does not exist, copy it from the assets.
        val mDataBaseExist = checkDataBase()
        if (!mDataBaseExist) {
            this.readableDatabase
            close()
            try {
                //Copy the database from assests
                copyDataBase()
                Log.e(TAG, "createDatabase database created")
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private fun checkDataBase(): Boolean {
        val dbFile = File(DB_PATH + DB_NAME)
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists()
    }

    //Copy the database from assets
    @Throws(IOException::class)
    private fun copyDataBase(): Boolean {
        return try {
            val inputStream = mContext!!.assets.open(DB_NAME)
            val outFileName = DB_PATH + DB_NAME
            val outputStream: OutputStream = FileOutputStream(outFileName)
            val buff = ByteArray(1024)
            var length: Int
            while (inputStream.read(buff).also { length = it } > 0) {
                outputStream.write(buff, 0, length)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    //Open the database, so we can query it
    @Throws(SQLException::class)
    fun openDataBase(): Boolean {
        val mPath = DB_PATH + DB_NAME
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY)
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null
    }

    @Synchronized
    override fun close() {
        if (mDataBase != null) mDataBase!!.close()
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase?) {
//        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}