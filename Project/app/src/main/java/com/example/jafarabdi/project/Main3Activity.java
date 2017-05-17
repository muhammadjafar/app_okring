package com.example.jafarabdi.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jafarabdi.project.akun.ProfilPenjual;

public class Main3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                            finish();
                            break;
                        case R.id.action_sale:
                            Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                        case R.id.action_chart:
                            startActivity(new Intent(getApplicationContext(), Recycle.class));
                            finish();
                            break;
                        case R.id.action_account:
                            startActivity(new Intent(getApplicationContext(), ProfilPenjual.class));
                            finish();
                            break;
                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Home");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        BottomNavigationView navigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        RecylerAdapter adapter=new RecylerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
