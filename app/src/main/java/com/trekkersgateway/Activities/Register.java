package com.trekkersgateway.Activities;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.trekkersgateway.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment implements View.OnClickListener {
    EditText name, phone, email, username, password;
    TextView dob;
    Button btnRegister, btnGotoLogin, btnCalendar;
    int day, month, year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listener;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initiate(view);
        return view;
    }

    public void initiate(View v) {
        name = v.findViewById(R.id.regname);
        phone = v.findViewById(R.id.regphone);
        email = v.findViewById(R.id.regemail);
        dob = v.findViewById(R.id.tvDate);
        username = v.findViewById(R.id.regusername);
        password = v.findViewById(R.id.regpass);

        btnCalendar = v.findViewById(R.id.btndate);
        btnRegister = v.findViewById(R.id.regregister);
        btnGotoLogin = v.findViewById(R.id.btngotologin);

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
        datePickerDialog=new DatePickerDialog(getActivity(),listener,year,month+1,day);
    }


    public void setDate(int year,int month, int day){
        dob.setText(year+"-"+month+"-"+day);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndate:
                datePickerDialog.show();

                break;
            case R.id.btngotologin:
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);

                break;
            case R.id.regregister:


                break;
        }
    }
}
