package com.grishon.rb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    Spinner cmpny_accs_spinner;
    TextView welcome_text;
    ImageButton add_cmpny_img_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        cmpny_accs_spinner = findViewById(R.id.account_select);
        welcome_text = findViewById(R.id.welcome_text);
        add_cmpny_img_btn = findViewById(R.id.add_cmpny_img_btn);


        add_cmpny_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create_account = new Intent(getBaseContext(), CreateNewCompany.class);

                startActivity(create_account);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.account, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmpny_accs_spinner.setAdapter(adapter);


    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}
