package com.example.jafarabdi.project.akun;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jafarabdi.project.Main2Activity;
import com.example.jafarabdi.project.Main3Activity;
import com.example.jafarabdi.project.R;
import com.example.jafarabdi.project.Recycle;
import com.example.jafarabdi.project.login.LoginActivity;
import com.example.jafarabdi.project.login.SharedPrefManager;

public class ProfilPenjual extends AppCompatActivity {
    private TextView userprofil, emailprofil;
    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                            finish();
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
                            Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_penjual);

        BottomNavigationView navigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        userprofil=(TextView) findViewById(R.id.usernameProfil);
        emailprofil=(TextView) findViewById(R.id.emailProfil);

        userprofil.setText(SharedPrefManager.getInstance(this).getUsername());
        emailprofil.setText(SharedPrefManager.getInstance(this).getUseremail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        return true;
    }
}
