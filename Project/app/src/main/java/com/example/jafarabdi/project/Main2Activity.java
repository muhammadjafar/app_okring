package com.example.jafarabdi.project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jafarabdi.project.akun.ProfilPenjual;
import com.example.jafarabdi.project.akun.TabProfilPenjual;
import com.example.jafarabdi.project.login.LoginActivity;
import com.example.jafarabdi.project.login.SharedPrefManager;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                            //finish();
                            break;
                        case R.id.action_sale:
                            startActivity(new Intent(getApplicationContext(), Main3Activity.class));
                            finish();
                            break;
                        case R.id.action_chart:
                            startActivity(new Intent(getApplicationContext(), Recycle.class));
                            finish();
                            break;
                        case R.id.action_account:
                            startActivity(new Intent(getApplicationContext(), TabProfilPenjual.class));
                            break;
                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle(R.string.home);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView navigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        textView=(TextView) findViewById(R.id.textVie);
        CardView cardView=(CardView) findViewById(R.id.cv_main2);
        cardView.setCardElevation(0.5f);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchitem=menu.findItem(R.id.search);
        final SearchView searchView=(SearchView) MenuItemCompat.getActionView(searchitem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                //textView.setText("Hasil Pencarian query"+query);
                //searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        return true;
    }*/

    @Override
    public void onClick(View v) {

    }
}
