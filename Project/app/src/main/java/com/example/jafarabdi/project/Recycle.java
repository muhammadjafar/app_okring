package com.example.jafarabdi.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jafarabdi.project.adapter.MyAdapter;
import com.example.jafarabdi.project.akun.ProfilPenjual;

public class Recycle extends AppCompatActivity {
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
                            startActivity(new Intent(getApplicationContext(), Main3Activity.class));
                            finish();
                            break;
                        case R.id.action_chart:
                            Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
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
    GridLayoutManager layoutManager;
    private String nameList[]={
        "O Kring", "Chart"
    };
    private int iconId[]={
            R.drawable.okring, R.drawable.ic_chart
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("List");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        BottomNavigationView navigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        layoutManager=new GridLayoutManager(Recycle.this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter=new MyAdapter(Recycle.this, iconId, nameList);
        recyclerView.setAdapter(myAdapter);
    }
}
