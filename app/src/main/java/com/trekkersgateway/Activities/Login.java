package com.trekkersgateway.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.trekkersgateway.R;

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

    public void Login(){
      if(txtusername.getText().toString().isEmpty()){
          txtusername.setError("Enter Username");
          txtusername.requestFocus();
      }
      else if(pwpass.getText().toString().isEmpty()){
          pwpass.setError("Enter Password");
          pwpass.requestFocus();
      }
      else if(pwpass.getText().toString().isEmpty()&&pwpass.getText().toString().isEmpty()){
            txtusername.setError("Enter Password");
            pwpass.setError("Enter Password");
            txtusername.requestFocus();
        }else{


      }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                Login();

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
