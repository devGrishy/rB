package com.grishon.rb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Verify extends AppCompatActivity {

    TextView cmpny_phone_verify_text;
    EditText cmpny_phone_no;
    Button btn_verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        cmpny_phone_verify_text = findViewById(R.id.cmpny_phone_no_textview);
        cmpny_phone_no = findViewById(R.id.cmpny_phone_no);
        btn_verify = findViewById(R.id.btn_verify);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
            }
        });
    }
    public void verify(){
        String verify_text = "Verify";
        String verify_hint = "Enter 4 digit code";

        cmpny_phone_verify_text.setText(verify_text);
        cmpny_phone_no.setHint(verify_hint);


        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeintent = new Intent(getBaseContext(), Welcome.class);
                welcomeintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(welcomeintent);
                finish();

            }
        });

    }

}
