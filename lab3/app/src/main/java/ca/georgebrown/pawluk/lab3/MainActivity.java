package ca.georgebrown.pawluk.lab3;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnInternal, btnContacts, btnBrowser, btnMaps;

    public static final String KEY = "TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find references to the views you will use
        btnInternal = findViewById(R.id.btnInternal);
        btnContacts = findViewById(R.id.btnContacts);
        btnBrowser = findViewById(R.id.btnBrowser);
        btnInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),
                        SecondActivity.class);
                i.putExtra(KEY, "Hello from Main Activity");
                startActivity(i);
            }
        });

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                        // content://contacts
                startActivity(i);
                //startActivityForResult()
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = findViewById(R.id.editURI);
                String url = et.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/search?q="+url));
                startActivity(i);
            }
        });
        btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:43.6708731,-79.4141207?q=food"));
                startActivity(i);
            }
        });

    }
}
