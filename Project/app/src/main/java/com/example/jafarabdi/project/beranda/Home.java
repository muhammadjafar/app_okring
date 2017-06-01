package com.example.jafarabdi.project.beranda;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jafarabdi.project.R;
import com.example.jafarabdi.project.akun.TabProfilPenjual;
import com.example.jafarabdi.project.connect.Constants;

public class Home extends AppCompatActivity {
    //public static final String JSON_URL = "http://192.168.42.44/Android/v1/home.php";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle(R.string.home);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        //finish();
                        break;
                    case R.id.action_sale:
                        Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.action_chart:
                        Toast.makeText(getBaseContext(), "Message", Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.action_account:
                        startActivity(new Intent(getApplicationContext(), TabProfilPenjual.class));
                        break;
                }
                return true;
            }
        });
        listView = (ListView) findViewById(R.id.list);
        getData();
    }
    private void getData(){
        StringRequest stringRequest=new StringRequest(Constants.URL_HOME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomDetail cl = new CustomDetail(this, ParseJSON.ids, ParseJSON.names,ParseJSON.alamat, ParseJSON.image);
        listView.setAdapter(cl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_beranda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.about){
            startActivity(new Intent(getApplicationContext(), AboutUs.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
