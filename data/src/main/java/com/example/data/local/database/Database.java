package com.example.data.local.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.data.local.database.libs.DataBaseHelper;
import com.example.domain.model.PokemonModel;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Microstar on 21.05.2019.
 */

public class Database {
    private static final String TAG = "TAG";

    private static final String TABLE_NAME = "POKEMON";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String IMAGE = "min_size";
    private static Database database;
    private final DataBaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    public Database(Context mContext) {
        mDbHelper = new DataBaseHelper(mContext);
    }

    public static Database init(Context context) {
        if (database == null) {
            database = new Database(context);
            database = new Database(context);
        }
        return database;
    }

    public static Database getDatabase() {
        return database;
    }

    public Database createDatabase() {
        try {
            mDbHelper.createDataBase();
            Log.d("jkfnsdfj", "created");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Database open() throws SQLException {
        try {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
            Log.d("jkfnsdfj", "open: readble" + mDb);
        } catch (SQLException mSQLException) {
            Log.e(TAG, "open >>" + mSQLException);
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Database clearTable() {
        mDb.execSQL("DELETE FROM POKEMON");
        return this;
    }


    @SuppressLint("Range")
    public ArrayList<PokemonModel> getStudents() {
        ArrayList<PokemonModel> data = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("select * from POKEMON", null);
//        String []a=new String[4];
//        a[0]="id";
//        a[1]="name";
//        Cursor cursorx = mDb.query("Student",a);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data.add(new PokemonModel(
                    cursor.getString(cursor.getColumnIndex(ID)),
                    cursor.getString(cursor.getColumnIndex(NAME)),
                    cursor.getString(cursor.getColumnIndex(IMAGE))));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    ///////////delete by id
    public int deleteUser(int id) {
        return mDb.delete(TABLE_NAME, "id=" + id, null);
//        mDb.rawQuery("Delete from Student where id=" + id, null);
    }

    /////add new user////////////////
    public PokemonModel addUser(PokemonModel userData) {
        ContentValues values = new ContentValues();
        values.put(ID, userData.get_id());
        values.put(IMAGE, userData.getUrl());
        values.put(NAME, userData.getName());
        long id = mDb.insert(TABLE_NAME, null, values);
//        long id2 = mDb.rawQuery("insert into Student(n)")
//        userData.setId(String.valueOf(id));
        userData.set_id(String.valueOf(id));
        return userData;
    }

    /////for edit user
    public void editUser(PokemonModel userData) {
        ContentValues values = new ContentValues();
        values.put(ID, userData.get_id());
        values.put(NAME, userData.getName());
        values.put(ID, userData.getUrl());
        mDb.update(TABLE_NAME, values, "id=" + userData.get_id(), null);
//        mDb.rawQuery("update student set name="+name+"set number")
    }

}