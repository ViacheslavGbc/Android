package ca.georgebrown.lab7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private WordViewModel wordViewModel;
    public static final int NEW_WORD_ACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final WordAdapter adapter = new WordAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.setWords(words);
            }
        });*/
        ListView listview;
        listview=findViewById(R.id.listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MyContent.ITEMS);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                /*Intent i = new Intent(v.getContext(), NewWordActivity.class);
                startActivityForResult(i, NEW_WORD_ACT);
                */
                Intent i = new Intent(v.getContext(), DelWordActivity.class);
                startActivity(i);
                // startActivityForResult(i, NEW_WORD_ACT);

                //MyContent.removeElement(MyContent.ITEMS.get(position)); // remove element on click here

                //finish();                   // refresh the activity
                //startActivity(getIntent());
            }
        });




        FloatingActionButton bt = findViewById(R.id.floatingActionButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewWordActivity.class);
               startActivity(i);
                // startActivityForResult(i, NEW_WORD_ACT);
            }
        });
    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_WORD_ACT && resultCode == RESULT_OK){
            Word w = new Word(data.getStringExtra(NewWordActivity.EXTRA_WORD));
            wordViewModel.insert(w);
        }else{
            Toast.makeText(this,"No word added", Toast.LENGTH_LONG).show();
        }
    }

 */
}
