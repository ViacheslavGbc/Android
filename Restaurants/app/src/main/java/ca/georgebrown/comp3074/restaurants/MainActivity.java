package ca.georgebrown.comp3074.restaurants;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    //--- DatabaseHelper myDb;
    ListView restaurantList;

    public static RestaurantManager.Restaurant restaurant;
    private ArrayAdapter arrayAdapter;

    public void Fetchdb()
    {
        DatabaseHelper myDb = new DatabaseHelper(this);

        SQLiteDatabase db = myDb.getReadableDatabase();

        Cursor res = myDb.getAllItems(/*db*/);

        //listView = (ListView) view.findViewById(R.id.listViewItems);
        restaurantList = (ListView) findViewById(R.id.itemList);

        //final ArrayList list = RestaurantManager.ITEMS;
        ArrayList listData = RestaurantManager.ITEMS ;

        if(res.getCount() == 0) {         // database is empty...
            //---restaurantList.setAdapter(new CustomListAdapter(this, listData));

            arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_expandable_list_item_1,
                    listData
            );

        } else
        {

            if(listData.isEmpty()) {//  there are no restaurants in the manager && db is full

                RestaurantManager.Restaurant item;


                while (res.moveToNext()) {


                    String restName = res.getString(res.getColumnIndexOrThrow("NAME"));
                    String restTYPE = res.getString(res.getColumnIndexOrThrow("TYPE"));
                    item = RestaurantManager.createElement(restName, restTYPE);
                    item.setAddress(res.getString(res.getColumnIndexOrThrow("ADDRESS")));
                    item.setPhone(res.getString(res.getColumnIndexOrThrow("PHONE")));
                    item.setWebsite(res.getString(res.getColumnIndexOrThrow("WEBSITE")));
                    item.setRate(res.getString(res.getColumnIndexOrThrow("RATE")));
                    item.setPrice(res.getString(res.getColumnIndexOrThrow("PRICE")));
                    item.setOtherTags(res.getString(res.getColumnIndexOrThrow("TAGS")));

                    RestaurantManager.ITEMS.add(item);

                }
                db.close(); // 6:07
                res.close();
            }

            arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_expandable_list_item_1,
                    listData
            );
        }
        res.close();

        /////restaurantList.setAdapter(arrayAdapter);

        restaurantList.setAdapter(new CustomListAdapter(this, listData));
        ((ArrayAdapter)restaurantList.getAdapter()).notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//***************************************************************************************

        Fetchdb();

// ***************************************************************************************

        //-- myDb = new DatabaseHelper(this);
         //arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,RestaurantManager.ITEMS);
        //viewAll();
        ///ArrayList listData = read();
        //arrayAdapter = new CustomListAdapter(this, listData);


        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent e = new Intent(view.getContext(),RestaurantDetails.class);
                e.putExtra("RestaurantPosition", i);
                startActivity(e);
            }
        });

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(v.getContext(),AboutActivity.class);
                startActivity(e);

            }
        });

        FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(view.getContext(), AddNewRestaurant.class);
                startActivityForResult(i, 1);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    protected void onResume() {
        super.onResume();
//***************************************************************************************

        Fetchdb();

// ***************************************************************************************



            //arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,RestaurantManager.ITEMS);
            //viewAll();
            ///ArrayList listData = read();

        ////ArrayList listData= RestaurantManager.ITEMS;
            //listData.clear();
            //listData= RestaurantManager.ITEMS;
        ////restaurantList = (ListView) findViewById(R.id.itemList);
        ////restaurantList.setAdapter(new CustomListAdapter(this, listData));

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
