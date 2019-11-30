package ca.georgebrown.comp3074.restaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewRestaurant extends AppCompatActivity {

    DatabaseHelper myDb;

    public static  RestaurantManager.Restaurant restaurant;

    public ArrayList<Restaurant> restaurants;

    EditText txtName, txtType, txtAddress, txtPhone, txtWebsite,
            txtRate, txtPrice,txtOtherTags;

    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_restaurant);

        myDb = new DatabaseHelper(this);

        txtName = (EditText) findViewById(R.id.txtName);
        txtType = (EditText) findViewById(R.id.txtType);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtWebsite = (EditText) findViewById(R.id.txtWebsite);
        txtRate = (EditText) findViewById(R.id.txtRate);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtOtherTags = (EditText) findViewById(R.id.txtOthersTags);
        btnSave = findViewById(R.id.btnSave);
        AddData();
    }

    public void AddData() {
        btnSave.setOnClickListener(
                new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String name = txtName.getText().toString();
                    String type = txtType.getText().toString();
                    String price = txtPrice.getText().toString();
                    String address = txtAddress.getText().toString();
                    String phone = txtPhone.getText().toString();
                    String website = txtWebsite.getText().toString();
                    String rate = txtRate.getText().toString();
                    String otherTags = txtOtherTags.getText().toString();

                  boolean IsInserted = myDb.insertData(name, type, address,
                          phone, website, rate, price, otherTags);

                  if(IsInserted) Toast.makeText(AddNewRestaurant.this, "Data Is Saved", Toast.LENGTH_LONG).show();
                    else Toast.makeText(AddNewRestaurant.this, "Data Is Not Saved", Toast.LENGTH_LONG).show();

                    restaurant = RestaurantManager.createElement(name, type);
                    restaurant.setPrice(price);
                    restaurant.setAddress(address);
                    restaurant.setPhone(phone);
                    restaurant.setWebsite(website);
                    restaurant.setRate(rate);
                    restaurant.setOtherTags(otherTags);

                    RestaurantManager.ITEMS.add(restaurant);

                    //RestaurantManager.ITEM_MAP.put(restaurant.getId(), restaurant);

                    finish();
                }
        });
    }
}
