package com.zaoqibu.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vwarship on 2015/3/4.
 */
public class DBAdapter {
    static final String TAG = "DBAdapter";

    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_EMAIL = "email";

    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "contacts";
    static final int DATABASE_VERSION = 1;

    final Context context;
    DatabaseHelper dbHelper;

    SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("create table contacts (_id integer primary key autoincrement, name text not null, email text not null);");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "upgrade");
            db.execSQL("drop table if exists contacts");
            onCreate(db);
        }
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertContact(String name, String email) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_EMAIL, email);
        return db.insert(DATABASE_TABLE, null, cv);
    }

    public boolean deleteContact(long rowId) {
        return db.delete(DATABASE_TABLE, String.format("%s=%d", KEY_ROWID, rowId), null) > 0;
    }

    public Cursor getAllContacts() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_NAME, KEY_EMAIL}, null, null, null, null, null);
    }

    public Cursor getContact(long rowId) {
        Cursor cursor = db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID, KEY_NAME, KEY_EMAIL}, String.format("%s=%d", KEY_ROWID, rowId),null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public boolean updateContact(long rowId, String name, String email) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_EMAIL, email);
        return db.update(DATABASE_TABLE, cv, String.format("%s=%d", KEY_ROWID, rowId), null) > 0;
    }

}
