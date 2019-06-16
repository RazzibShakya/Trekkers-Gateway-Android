package com.trekkersgateway.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trekkersgateway.Model.Functions;
import com.trekkersgateway.Model.LoginResponse;
import com.trekkersgateway.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtusername, pwpass;
    Button btnlogin;
    TextView btnregister, btnforget;
    SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        initiate();
        preferences = getSharedPreferences("APP", MODE_PRIVATE);
        editor=preferences.edit();
    }

    public void initiate() {
        txtusername = findViewById(R.id.txtuser);
        pwpass = findViewById(R.id.txtpass);
        btnlogin = findViewById(R.id.btnLogin);
        btnregister = findViewById(R.id.btnregister);

        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);
    }

    //this is for login
    private void Login(String username,String password){

        Functions fun=new Functions();
        Call<LoginResponse> userCall=fun.createInstanceofRetrofit().checkUser(username.trim(),password.trim());
        userCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Login.this,"Your username or password is incorrect",Toast.LENGTH_SHORT).show();
                }else{
                    if(!response.body().getToken().equals(null)){
                        Toast.makeText(Login.this,"Your have successfully signed in"+response.body().getToken(),Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Login.this,Dashboard.class);
                        startActivity(intent);
                        editor.putString("token", response.body().getToken());
                        editor.commit();
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Error:"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public boolean checkUser(){
      if(txtusername.getText().toString().isEmpty()){
          txtusername.setError("Enter Username");
          txtusername.requestFocus();
          return false;
      }
      else if(pwpass.getText().toString().isEmpty()){
          pwpass.setError("Enter Password");
          pwpass.requestFocus();
          return false;
      }
      else if(pwpass.getText().toString().isEmpty()&&pwpass.getText().toString().isEmpty()){
            txtusername.setError("Enter Password");
            pwpass.setError("Enter Password");
            txtusername.requestFocus();
            return false;
        }else{
return true;
          
      }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if(checkUser()==true){
                    Login(txtusername.getText().toString(),pwpass.getText().toString());
                }

                break;
            case R.id.btnregister:
                Intent intent=new Intent(Login.this, Register.class);
                startActivity(intent);


                break;
            case R.id.btnforgot:



                break;
        }
    }
}
