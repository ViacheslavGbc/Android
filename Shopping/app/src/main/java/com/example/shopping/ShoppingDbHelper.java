package com.example.shopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShoppingDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shopping.db";
    public static final int DATABASE_VERSION = 1;

    public ShoppingDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShoppingStatement.Queries.SQL_CREATE);
        Log.d("DATABASE", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ShoppingStatement.Queries.SQL_DROP);
        Log.d("DATABASE", "Database dropped");
        onCreate(db);
    }

    public long insert(SQLiteDatabase db, String shoppingItem){

        ContentValues values = new ContentValues();
        values.put(ShoppingStatement.Queries.COLUMN_NAME_SHOPPING_ITEM, shoppingItem);

        return db.insert(ShoppingStatement.Queries.TABLE_NAME, null, values);
    }


    public void delete(SQLiteDatabase db, String getID) {
        db.execSQL("DELETE FROM " + ShoppingStatement.Queries.TABLE_NAME + " WHERE _ID = '" + getID + "'");
    }

    public Cursor getAllShoppingItems(SQLiteDatabase db){

        String[] projection = {
                ShoppingStatement.Queries._ID,
                ShoppingStatement.Queries.COLUMN_NAME_SHOPPING_ITEM
        };

        return db.query(ShoppingStatement.Queries.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }

    public  Cursor getAllItems(SQLiteDatabase db){
        return db.rawQuery("SELECT * FROM " + ShoppingStatement.Queries.TABLE_NAME, null );
    }
}
