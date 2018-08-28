package com.grishon.rb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Record extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Spinner cmpny_accs_spinner;


        cmpny_accs_spinner = findViewById(R.id.account_select);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.account, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmpny_accs_spinner.setAdapter(adapter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer);


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_rB:
                        Intent create_new_company_intent = new Intent(getBaseContext(), Welcome.class);

                        create_new_company_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(create_new_company_intent);
                        finish();
                        return true;
                    case R.id.nav_company:
                        Intent company_dashboard_intent = new Intent(getBaseContext(), NewCompany.class);

                        company_dashboard_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(company_dashboard_intent);
                        finish();

                        return true;
                    case R.id.nav_clients:
                        Intent clients_intent = new Intent(getBaseContext(), Clients.class);

                        clients_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(clients_intent);
                        finish();
                        return true;
                    case R.id.nav_analyze:
                        Intent analyze_intent = new Intent(getBaseContext(), Analyze.class);

                        analyze_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(analyze_intent);
                        finish();
                        return true;
                    case R.id.nav_record:
                        Intent record_intent = new Intent(getBaseContext(), Record.class);

                        record_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(record_intent);
                        finish();
                        return true;
                    case R.id.nav_payments:
                        Intent payments_intent = new Intent(getBaseContext(), Payments.class);

                        payments_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(payments_intent);
                        finish();return true;
                    case R.id.nav_settings:
                        Intent settings_intent = new Intent(getBaseContext(), CreateNewCompany.class);

                        settings_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(settings_intent);
                        finish();
                    default:
                        return false;
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_company:
                Toast.makeText(this, "Good work", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
