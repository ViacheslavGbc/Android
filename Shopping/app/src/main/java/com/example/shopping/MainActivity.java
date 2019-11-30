package com.example.shopping;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity
        extends FragmentActivity
        implements  ItemFragment.OnListFragmentInteractionListener,
                    AddItemFragment.OnAddItemFragmentInteractionListener,
                    DetailsItemFragment.OnFragmentInteractionListener  {

    public static FragmentManager manager;
    private ListView shoppingList;
    public static ShoppingManager.Shopping currentItem;
    private ArrayAdapter arrayAdapter;

    private ItemFragment itemFragment;
    private DetailsItemFragment detailsItemFragment;

   // public ShoppingDbHelper shoppingDbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        manager = getSupportFragmentManager();


        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null) return;

             detailsItemFragment = new DetailsItemFragment();
            itemFragment = new ItemFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.container, itemFragment);
            transaction.commit();

        }

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


    @Override
    public void onListFragmentInteraction(ShoppingManager.Shopping item) {
        Log.d("MainActivity", " > ItemFragment onListFragmentInteraction item: " + item.id + " - " + item);

        detailsItemFragment.updateView(item);
       manager.beginTransaction().replace(R.id.container, new ItemFragment(), null).commit();
    }

    @Override
    public void onFragmentInteraction(ShoppingManager.Shopping item) {
        Log.d("MainActivity", " > DetailFragment onFragmentInteraction item: " +  item.id + " - " + item);

      //  ItemFragment itemFragment = new ItemFragment();
      //  itemFragment.updateView(item);

      manager.beginTransaction().replace(R.id.container, new ItemFragment(), null).commit();

    }

    @Override
    public void OnAddItemFragmentInteraction(ShoppingManager.Shopping item) {
        Log.d("MainActivity", " > OnAddItemFragmentInteraction item: " +  item.id + " - " + item);

       manager.beginTransaction().replace(R.id.container, new ItemFragment(), null).commit();
    }
}
