package com.example.pokemon.utils.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.domain.model.PokemonModel
import com.example.pokemon.utils.database.libs.DataBaseHelperKotlin
import com.example.pokemon.utils.database.model.DbModel
import java.io.IOException

class DatabaseKotlin {
    private val TAG = "TAG"

    private val TABLE_NAME = "POKEMON"
    private val ID = ""
    private val NAME = "name";
    private val IMAGE = ""
    private var database: DatabaseKotlin? = null
    private var mDbHelper: DataBaseHelperKotlin? = null
    private var mDb: SQLiteDatabase? = null

    constructor(context: Context) {
        mDbHelper = DataBaseHelperKotlin(context)
    }

    constructor()

    fun init(context: Context): DatabaseKotlin? {
        if (DatabaseKotlin().database == null) {
            DatabaseKotlin().database = DatabaseKotlin(context)
        }
        return database
    }

    fun getDatabase(): DatabaseKotlin? {
        return database
    }

    fun clearTable(): DatabaseKotlin? {
        mDb?.execSQL("DELETE FROM $TABLE_NAME")
        return database
    }

    fun createDatabase(): DatabaseKotlin {
        try {
            mDbHelper!!.createDataBase()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return this
    }

    @Throws(SQLException::class)
    fun open(): DatabaseKotlin {
        mDb = try {
            mDbHelper!!.openDataBase()
            mDbHelper!!.close()
            mDbHelper!!.readableDatabase
        } catch (mSQLException: SQLException) {
            Log.e(TAG, "open >>$mSQLException")
            throw mSQLException
        }
        return this
    }


    fun close() {
        mDbHelper!!.close()
    }

    @SuppressLint("Range")
    fun getStudents(): ArrayList<PokemonModel> {
        val data = ArrayList<PokemonModel>()
        val cursor = mDb!!.rawQuery("select * from $TABLE_NAME", null)
        //        String []a=new String[4];
//        a[0]="id";
//        a[1]="name";
//        Cursor cursorx = mDb.query("Student",a);
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            data.add(
                PokemonModel(
                    cursor.getString(cursor.getColumnIndex(ID)),
                    cursor.getString(cursor.getColumnIndex(NAME)),
                    cursor.getString(cursor.getColumnIndex(IMAGE))
                )
            )
            cursor.moveToNext()
        }
        cursor.close()
        return data
    }

    ///////////delete by id
    fun deleteUser(id: Int): Int {
        return mDb!!.delete("data", "id=$id", null)
//        mDb.rawQuery("Delete from Student where id=" + id, null);
    }

    /////add new user////////////////
    fun addUser(userData: PokemonModel): PokemonModel {
        val values = ContentValues()
        values.put(ID, userData._id)
        values.put(NAME, userData.name)
        values.put(IMAGE, userData.url)
        val id: Long? = mDb?.insert(TABLE_NAME, null, values)
        //        long id2 = mDb.rawQuery("insert into Student(n)")
//        userData.setId(id)
        userData._id = id.toString()
        Log.d(TAG, "addUser: $mDb")
        return userData
    }

    /////for edit user
    fun editUser(userData: PokemonModel) {
        val values = ContentValues()
        values.put(NAME, userData.name)
        values.put(IMAGE, userData.url)
        mDb!!.update(TABLE_NAME, values, "id=" + userData._id, null)
//        mDb.rawQuery("update student set name="+name+"set number")
    }
}