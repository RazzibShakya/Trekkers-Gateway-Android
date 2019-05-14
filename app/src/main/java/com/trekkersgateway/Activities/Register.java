package com.trekkersgateway.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.trekkersgateway.R;

import java.util.Calendar;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText name, phone, email, username, password;
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
    public boolean RegisterValidation(){
        boolean res=false;
        if(name.getText().toString().isEmpty()){
            name.setError("Fill Your Name");
            name.requestFocus();
        }
        if(phone.getText().toString().isEmpty()){
            phone.setError("Fill Your phone number");
            phone.requestFocus();
        }

        if(email.getText().toString().isEmpty()){
            email.setError("Fill Your email");
            email.requestFocus();
        }

        if(username.getText().toString().isEmpty()){
            username.setError("Fill Your username");
            username.requestFocus();
        }

        if(password.getText().toString().isEmpty()){
            password.setError("Fill Your password");
            password.requestFocus();
        }
        if(!TextUtils.isEmpty(name.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())&&!TextUtils.isEmpty(phone.getText().toString())&&
                !TextUtils.isEmpty(email.getText().toString())&&!TextUtils.isEmpty(username.getText().toString())&&!TextUtils.isEmpty(password.getText().toString())){
            res=true;
        }else{
            name.setError("Fill Your Name");
            phone.setError("Fill Your phone number");
            email.setError("Fill Your email");
            password.setError("Fill Your password");
            username.setError("Fill Your username");
            name.requestFocus();
        }
        return res;
    }

    //this method is to save users into database or apu

    public void Register(){






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

                }


                break;
        }
    }
}
