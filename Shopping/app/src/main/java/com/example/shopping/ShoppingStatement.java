package com.example.shopping;

import android.provider.BaseColumns;

public final class ShoppingStatement {
    
    private ShoppingStatement() {}

    public static class Queries implements BaseColumns {
        
    public static final String TABLE_NAME = "shopping";
    public static final String COLUMN_NAME_ID = _ID;
    public static final String COLUMN_NAME_SHOPPING_ITEM = "shopping_item";
    public static final String SQL_CREATE = "CREATE TABLE "+
                TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_SHOPPING_ITEM + " TEXT )";

    /*
    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_SHOPPING_ITEM + " TEXT )";
    */

    public static final String SQL_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
