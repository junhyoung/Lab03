package github.com.junhyoung.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    Button btOk;
    Button btCc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        btOk=(Button)findViewById(R.id.bt_ok);
        btCc=(Button)findViewById(R.id.bt_cc);
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editText);
                String message = editText.getText().toString();
                Intent intent;
                intent=new Intent(NewActivity.this,MainActivity.class);
                intent.putExtra("github.com.junhyoung.lab03", message);
                startActivity(intent);
            }
        });
        btCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

}
