package com.trekkersgateway.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trekkersgateway.Model.Functions;
import com.trekkersgateway.Model.LoginResponse;
import com.trekkersgateway.Model.User;
import com.trekkersgateway.Model.UserAPI;
import com.trekkersgateway.R;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText name, phone, email, username, password,address;
    TextView dob,btnGotoLogin;
    Button btnRegister,  btnCalendar;
    int day, month, year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        initiate();
    }
    public void initiate() {
        name = findViewById(R.id.regname);
        phone = findViewById(R.id.regphone);
        email = findViewById(R.id.regemail);
        dob = findViewById(R.id.tvDate);
        username = findViewById(R.id.regusername);
        password = findViewById(R.id.regpass);
        address = findViewById(R.id.regaddress);

        btnCalendar = findViewById(R.id.btndate);
        btnRegister = findViewById(R.id.regregister);
        btnGotoLogin = findViewById(R.id.btngotologin);

        btnCalendar.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnGotoLogin.setOnClickListener(this);

        SelectDate();
    }

    public void SelectDate(){
        Calendar calendar = Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        setDate(year,month+1,day);
        listener=new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int day) {
                setDate(year,month+1,day);
            }
        };
        datePickerDialog=new DatePickerDialog(this,listener,year,month+1,day);
    }

//this is method for setting date from date picker
    public void setDate(int year,int month, int day){
        dob.setText(year+"-"+month+"-"+day);
    }

//this method is for validating the textfields
    public boolean RegisterValidation() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (TextUtils.isEmpty(name.getText().toString()) && TextUtils.isEmpty(password.getText().toString()) && TextUtils.isEmpty(phone.getText().toString()) &&
                TextUtils.isEmpty(email.getText().toString()) && TextUtils.isEmpty(username.getText().toString()) && TextUtils.isEmpty(password.getText().toString())) {
            name.setError("Fill Your Name");
            phone.setError("Fill Your phone number");
            email.setError("Fill Your email");
            password.setError("Fill Your password");
            username.setError("Fill Your username");
            address.setError("Fill Your address");
            name.requestFocus();
            return false;
        }
        if (name.getText().toString().isEmpty()) {
            name.setError("Fill Your Name");
            name.requestFocus();
            return false;
        }
        if (phone.getText().toString().isEmpty()) {
            phone.setError("Fill Your phone number");
            phone.requestFocus();
            return false;
        }

        if (email.getText().toString().isEmpty() || !email.getText().toString().trim().matches(emailPattern)) {
            email.setError("Your email is invalid");
            email.requestFocus();
            return false;
        }

        if (address.getText().toString().isEmpty()) {
            address.setError("Fill Your address");
            address.requestFocus();
            return false;
        }

        if (username.getText().toString().isEmpty()) {
            username.setError("Fill Your username");
            username.requestFocus();
            return false;
        }

        if (password.getText().toString().isEmpty() || password.getText().toString().length() < 6) {
            password.setError("Invalid password or password must have atleast 6 characters");
            password.requestFocus();
            return false;
        }

        if (!dob.getText().toString().isEmpty()) {


        }else{
            dob.setError("Date is invalid");
            dob.requestFocus();
            return false;
        }

    return true;
    }



    //this method is to save users into database or api

    public void Register(){
        Functions rm=new Functions();
        User user=new User(name.getText().toString(),email.getText().toString(),phone.getText().toString(),
                dob.getText().toString(),address.getText().toString(),username.getText().toString(),password.getText().toString());
        Call<Void>addNewUser=rm.createInstanceofRetrofit().addNewUser(user);
        addNewUser.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(),"User added successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error :"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndate:
                datePickerDialog.show();

                break;
            case R.id.btngotologin:
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);

                break;
            case R.id.regregister:
                if(RegisterValidation()==true){
                    Register();
                }
                break;
        }
    }
}
