package com.example.a101184699_viacheslav_nepomniashchyi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    Button btn;//btnSubmit
    TextView labl;//lbl_equals
    EditText varZ;//txt_z
    EditText varS;//txt_s
    EditText varP;//txt_p


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnSubmit);
        labl = findViewById(R.id.lbl_equals);
        varZ = findViewById(R.id.txt_z);
        varS = findViewById(R.id.txt_s);
        varP = findViewById(R.id.txt_p);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                labl.setText("0");


                if(varZ.getText().toString() == null || varZ.getText().toString().equals("")||varZ.getText().toString().equals("-")||
                        varS.getText().toString() == null || varS.getText().toString().equals("")||varS.getText().toString().equals("-")||
                            varP.getText().toString() == null || varP.getText().toString().equals("")||varP.getText().toString().equals("-"))
                {
                    labl.setText("ERR");


                } else{
                    int Z = new Integer(varZ.getText().toString()).intValue();
                    int S = new Integer(varS.getText().toString()).intValue();
                    int P = new Integer(varP.getText().toString()).intValue();

                    int res=(72*Z)-(57*S)+(69*P);

                    if ((res<=10000000)||(res>-10000000)){
                        labl.setText(""+res+"");}
                    else {
                        labl.setText("*10E");
                    }


                }

            }
        });
    }
}