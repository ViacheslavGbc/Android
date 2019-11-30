package ca.georgebrown.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DelWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_word);

        Button btnDel = findViewById(R.id.btnDel);
        final TextView txtEdit = findViewById(R.id.txtView2);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent replyIntent = new Intent();

               /* if(TextUtils.isEmpty(wordEdit.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }else{*/

              //  String word = txtEdit.getText().toString();

                    /*replyIntent.putExtra(EXTRA_WORD, word);
                    setResult(RESULT_OK, replyIntent);*/

                finish();
            }
        });




    }
}
