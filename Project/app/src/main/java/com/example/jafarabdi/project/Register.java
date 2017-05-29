package com.example.jafarabdi.project;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jafarabdi.project.connect.Constants;
import com.example.jafarabdi.project.connect.RequestHandler;
import com.example.jafarabdi.project.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends Activity implements View.OnClickListener{
    private EditText editTextUsername, editTextEmail, editTextPassword, editTextTelp,editTextAlamat, editTextNama;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private TextView textViewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextUsername=(EditText) findViewById(R.id.textUsername);
        editTextNama=(EditText) findViewById(R.id.textNama);
        editTextPassword=(EditText) findViewById(R.id.textPassword);
        editTextEmail=(EditText) findViewById(R.id.textEmail);
        editTextTelp=(EditText) findViewById(R.id.textTelp);
        editTextAlamat=(EditText) findViewById(R.id.textAlamat);
        buttonRegister=(Button) findViewById(R.id.buttonRegister);
        textViewLogin=(TextView) findViewById(R.id.textLogin);
        progressDialog=new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);
    }
    private void registerUser(){
        final String email=editTextEmail.getText().toString().trim();
        final String username=editTextUsername.getText().toString().trim();
        final String nama=editTextNama.getText().toString().trim();
        final String password=editTextPassword.getText().toString().trim();
        final String telp=editTextTelp.getText().toString().trim();
        final String alamat=editTextAlamat.getText().toString().trim();
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("username", username);
                params.put("nama", nama);
                params.put("password", password);
                params.put("email", email);
                params.put("telp", telp);
                params.put("alamat", alamat);
                return params;
            }
        };
        /*RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);*/
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
    @Override
    public void onClick(View v) {
        if (v ==buttonRegister){
            registerUser();
        }
        if (v==textViewLogin){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}
