package ca.georgebrown.comp3074.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button btnDonate = findViewById(R.id.btnDonate);
        btnDonate.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {

                finish();

            }


        });


    }

}