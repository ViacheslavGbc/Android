package ca.georgebrown.lab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ca.georgebrown.lab5.dummy.DummyContent;

public class MainActivity extends FragmentActivity
        implements ItemFragment.OnListFragmentInteractionListener,
        ItemDetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(view.getContext(), AddItemActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                updateList();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void updateList(){
        FragmentManager manager = getSupportFragmentManager();
        ItemFragment fragment =
                (ItemFragment) manager
                        .findFragmentById(R.id.list_fragment);
        fragment.updateView();
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
    public void onListFragmentInteraction(
            DummyContent.DummyItem item) {

        Toast.makeText(this,
                "Selected: "+item.content,
                Toast.LENGTH_LONG).show();
        FragmentManager manager = getSupportFragmentManager();
        ItemDetailsFragment itemDetailsFragment =
                (ItemDetailsFragment) manager
                        .findFragmentById(R.id.details_fragment);
        itemDetailsFragment.setItem(item);
    }

    @Override
    public void onFragmentInteraction(DummyContent.DummyItem item) {
        DummyContent.ITEMS.remove(item);
        FragmentManager manager = getSupportFragmentManager();
        ItemFragment fragment =
                (ItemFragment) manager
                        .findFragmentById(R.id.list_fragment);
        fragment.updateView();
    }
}
