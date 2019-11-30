package ca.georgebrown.comp3074.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGo = findViewById(R.id.btnSave);
        final EditText txtBox1 = findViewById(R.id.txtEdit1);
        final EditText txtBox2 = findViewById(R.id.txtEdit2);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyContent.Element element = new MyContent.Element(1+"",txtBox1.getText()+"", txtBox2.getText()+"");
                MyContent.addItemElement(element);

                Intent i = new Intent(v.getContext(),
                        ListingActivity.class);
                startActivity(i);
            }
        });



    }
}
