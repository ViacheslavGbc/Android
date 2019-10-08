package ca.georgebrown.pawluk.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String data[] = {"First Sttudent",
    "Second Student", "Another Student", "Last Student"};

    public static final String KEY = "ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        final ArrayList<Student> values = new ArrayList<>();
        for (int i=0; i<data.length; i++){
            values.add(new Student(data[i], i));
        }

        final MyArrayAdapter adapter =
                new MyArrayAdapter(this,
                        R.layout.item_layout,
                        values
                );
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           final View view, int position,
                                           long id) {
                final Student item = (Student)parent
                        .getItemAtPosition(position);
                final View v = view;
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                values.remove(item);
                                adapter.notifyDataSetChanged();
                                v.setAlpha(1);
                            }
                        });

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position,
                                    long id) {
                final String item =
                        ((Student) parent.getItemAtPosition(position))
                                .getName();
                Intent intent = new Intent(parent.getContext(),
                        DetailsActivity.class);
                intent.putExtra(KEY,item);
                startActivity(intent);

            }
        });
    }
}
