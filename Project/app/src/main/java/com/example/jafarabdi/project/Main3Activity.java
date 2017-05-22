package com.example.jafarabdi.project;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jafarabdi.project.adapter.ImageCatering;
import com.example.jafarabdi.project.akun.ProfilPenjual;
import com.example.jafarabdi.project.akun.TabProfilPenjual;
import com.example.jafarabdi.project.connect.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    //private RecyclerView recyclerView;
    private List<ImageCatering> listCatering;

    //Creating Views
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
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
                            //finish();
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
        getSupportActionBar().setTitle("Home");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        BottomNavigationView navigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        //RecylerAdapter adapter=new RecylerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listCatering = new ArrayList<>();
        getData();
    }
    private void getData(){
        //Showing a progress dialog
        //final ProgressDialog loading = ProgressDialog.show(this,"Loading Data", "Please wait...",false,false);

        //Creating a json array request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Constants.URL_IMAGE,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing progress dialog
                        //loading.dismiss();

                        //calling method to parse json array
                        parseData(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(jsonArrayRequest);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    //This method will parse json data
    private void parseData(JSONArray array){
        for(int i = 0; i<array.length(); i++) {
            ImageCatering catering = new ImageCatering();
            JSONObject json = null;
            try {
                json = array.getJSONObject(i);
                catering.setImageUrl(json.getString(Constants.TAG_IMAGE_URL));
                catering.setName(json.getString(Constants.TAG_NAME));
                /*superHero.setRank(json.getInt(Config.TAG_RANK));
                superHero.setRealName(json.getString(Config.TAG_REAL_NAME));
                superHero.setCreatedBy(json.getString(Config.TAG_CREATED_BY));
                superHero.setFirstAppearance(json.getString(Config.TAG_FIRST_APPEARANCE));

                ArrayList<String> powers = new ArrayList<String>();

                JSONArray jsonArray = json.getJSONArray(Config.TAG_POWERS);

                for(int j = 0; j<jsonArray.length(); j++){
                    powers.add(((String) jsonArray.get(j))+"\n");
                }
                superHero.setPowers(powers);*/


            } catch (JSONException e) {
                e.printStackTrace();
            }
            listCatering.add(catering);
        }

        //Finally initializing our adapter
        adapter = new RecylerAdapter(listCatering, this);

        //Adding adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
