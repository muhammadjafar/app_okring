package com.example.jafarabdi.project.login;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jafarabdi.project.Main2Activity;
import com.example.jafarabdi.project.R;
import com.example.jafarabdi.project.Register;
import com.example.jafarabdi.project.connect.Constants;
import com.example.jafarabdi.project.connect.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private TextView textSignup;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsername=(EditText) findViewById(R.id.editTextUsername);
        editTextPassword=(EditText) findViewById(R.id.edtiTextPassword);
        buttonLogin =(Button) findViewById(R.id.buttonLogin);
        textSignup=(TextView) findViewById(R.id.textSignup);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");
        buttonLogin.setOnClickListener(this);
        textSignup.setOnClickListener(this);

    }
    private void userLogin(){
        final String username=editTextUsername.getText().toString().trim();
        final String password=editTextPassword.getText().toString().trim();
        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject object=new JSONObject(response);
                            if (!object.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(
                                        object.getInt("id"),
                                        object.getString("username"),
                                        object.getString("email")
                                );
                                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    @Override
    public void onClick(View v) {
        if (v==buttonLogin){
            userLogin();
        }
        if (v==textSignup){
            startActivity(new Intent(this, Register.class));
            finish();
        }
    }
}
