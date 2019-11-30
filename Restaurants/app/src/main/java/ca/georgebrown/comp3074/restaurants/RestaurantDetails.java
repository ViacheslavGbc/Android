package ca.georgebrown.comp3074.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantDetails extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        myDb = new DatabaseHelper(this);

        final TextView txtViewName = findViewById(R.id.txtViewName);
        final TextView txtViewType = findViewById(R.id.txtViewType);
        final TextView txtViewPrice = findViewById(R.id.txtViewPrice);

        final TextView txtViewAddress = findViewById(R.id.txtViewAddress);
        final TextView txtViewPhone = findViewById(R.id.txtViewPhone);
        final TextView txtViewWebsite = findViewById(R.id.txtViewWebsite);
        final TextView txtViewRate = findViewById(R.id.txtViewRate);
        final TextView txtViewOtherTags = findViewById(R.id.txtViewOtherTags);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final Integer i = extras.getInt("RestaurantPosition");

        txtViewName.setText(RestaurantManager.ITEMS.get(i).getName());
        txtViewType.setText(RestaurantManager.ITEMS.get(i).getType());
        txtViewPrice.setText(RestaurantManager.ITEMS.get(i).getPrice());

        txtViewAddress.setText(RestaurantManager.ITEMS.get(i).getAddress());
        txtViewPhone.setText(RestaurantManager.ITEMS.get(i).getPhone());
        txtViewWebsite.setText(RestaurantManager.ITEMS.get(i).getWebsite());
        txtViewRate.setText(RestaurantManager.ITEMS.get(i).getRate());
        txtViewOtherTags.setText(RestaurantManager.ITEMS.get(i).getOtherTags());

        txtViewRate.setText(RestaurantManager.ITEMS.get(i).getId());

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDb.delData(txtViewName.getText().toString());
               // RestaurantManager.removeElement(RestaurantManager.ITEMS.get(i));
                RestaurantManager.ITEMS.remove(RestaurantManager.ITEMS.get(i));
                finish();
            }
        });
    }
}
