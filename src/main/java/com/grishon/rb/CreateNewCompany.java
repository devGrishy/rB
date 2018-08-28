package com.grishon.rb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateNewCompany extends AppCompatActivity {
    Spinner cmpny_acc_spinner;
    EditText cmpny_email, cmpny_location;
    Button btn_create_new_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_company);

        cmpny_acc_spinner = findViewById(R.id.account_select);
        cmpny_email = findViewById(R.id.cmpny_email);
        cmpny_location = findViewById(R.id.cmpny_location);
        btn_create_new_company = findViewById(R.id.btn_create_new_company);

        btn_create_new_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewCompany();
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.account, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmpny_acc_spinner.setAdapter(adapter);
    }
    public void createNewCompany(){
        Intent create_new_company = new Intent(getBaseContext(), NewCompany.class);
        finish();
        create_new_company.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(create_new_company);



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
