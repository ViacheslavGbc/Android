package ca.georgebrown.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ca.georgebrown.lab5.dummy.DummyContent;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Button button = findViewById(R.id.button2);
        final TextView content = findViewById(R.id.content);
        final TextView desc = findViewById(R.id.details);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = content.getText().toString();
                String d = desc.getText().toString();
                DummyContent.ITEMS.add(new DummyContent.DummyItem(
                        ""+DummyContent.ITEMS.size(), c, d));
                Intent i = new Intent();
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }
}
