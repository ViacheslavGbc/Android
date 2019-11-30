package ca.georgebrown.comp3074.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static ca.georgebrown.comp3074.restaurants.MainActivity.restaurant;

public class DatabaseHelper extends SQLiteOpenHelper {

  public static final class Statement implements BaseColumns {

      public static final String DATABASE_NAME = "Restaurant.db";
      public static final String TABLE_NAME = "Restaurant_table";
      public static final String COL_1 = BaseColumns._ID;
      public static final String COL_2 = "Name";
      public static final String COL_3 = "Type";
      public static final String COL_4 = "Address";
      public static final String COL_5 = "Phone";
      public static final String COL_6 = "Website";
      public static final String COL_7 = "Rate";
      public static final String COL_8 = "Price";
      public static final String COL_9 = "Tags";

  }

    public DatabaseHelper(@Nullable Context context) {
        super(context, Statement.DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();  //Singleton to be added here
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Statement.TABLE_NAME+" (_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TYPE TEXT, ADDRESS TEXT, PHONE TEXT, WEBSITE TEXT, RATE TEXT, PRICE TEXT, TAGS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Statement.TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String type, String address,
                              String phone, String website, String rate,
                              String price, String tags){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Statement.COL_2, name);
        contentValues.put(Statement.COL_3, type);
        contentValues.put(Statement.COL_4, address);
        contentValues.put(Statement.COL_5, phone);
        contentValues.put(Statement.COL_6, website);
        contentValues.put(Statement.COL_7, rate);
        contentValues.put(Statement.COL_8, price);
        contentValues.put(Statement.COL_9, tags);
        //db.insert(TABLE_NAME, null, contentValues);

        long result = db.insert(Statement.TABLE_NAME, null, contentValues);
        db.close();

        if (result == -1 )
            return false;
        else
            return true;

    }


   public void delData(String getID) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + Statement.TABLE_NAME + " WHERE NAME = '" + getID + "'");

        //db.delete(Statement.TABLE_NAME, Statement.COL_2 + "=" + getID, null);
       db.close();
    }

    public  Cursor getAllItems(/*SQLiteDatabase db*/){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + Statement.TABLE_NAME, null );
    //    db.execSQL();

   }


}
