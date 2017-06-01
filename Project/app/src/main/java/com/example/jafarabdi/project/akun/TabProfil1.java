package com.example.jafarabdi.project.akun;

/**
 * Created by jafar abdi on 17/05/2017.
 */
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jafarabdi.project.R;
import com.example.jafarabdi.project.connect.Constants;

public class TabProfil1 extends Fragment{
    ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_profil_penjual1, container, false);
        return rootView;
    }
    /*private void getData(){
        StringRequest stringRequest=new StringRequest(Constants.URL_PAKET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        Daftar_paket pj = new Daftar_paket(json);
        pj.parseJSON();
        Detail_paket cl = new Detail_paket(getActivity(), Daftar_paket.names, Daftar_paket.paket, Daftar_paket.deskripsi, Daftar_paket.image);
        listView.setAdapter(cl);
    }*/
}
