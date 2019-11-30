package ca.georgebrown.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_WORD = "ca.georgebrown.lab7.NewWordActivity.EXTRA_WORD";
    private EditText wordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        Button b = findViewById(R.id.button);
        wordEdit = findViewById(R.id.editText);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(wordEdit.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }else{
                    MyContent.Element element = new MyContent.Element(1+"", wordEdit.getText().toString(), "some details if there are any");
                    MyContent.addItemElement(element);

//                    String w = wordEdit.getText().toString();
                    //replyIntent.putExtra(EXTRA_WORD, w);
                    replyIntent.putExtra(EXTRA_WORD, wordEdit.getText().toString());
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
