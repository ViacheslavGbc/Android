package ca.georgebrown.pawluk.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView txt = findViewById(R.id.textView);
        String msg = getIntent().getExtras()
                .getString(MainActivity.KEY, "NO DATA");
        txt.setText(msg);
    }
}
