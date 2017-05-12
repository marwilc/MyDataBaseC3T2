package com.marwilc.mydatabase;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Intent myActivityConfirm;
    private Contact myContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtnNext();


    }

    public void addBtnNext(){
        Button myButtonNext = (Button) findViewById(R.id.btnNext);
        myButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                extractData();

                myActivityConfirm = new Intent(getApplicationContext(),ConfirmActivity.class);
                myActivityConfirm.putExtra("fullName",myContact.getFullName());
                myActivityConfirm.putExtra("birthDate",myContact.getBirthDate());
                myActivityConfirm.putExtra("phone",myContact.getPhone());
                myActivityConfirm.putExtra("email",myContact.getEmail());
                myActivityConfirm.putExtra("detail",myContact.getDetail());
                startActivity(myActivityConfirm);
            }
        });
    }

    public void extractData(){

        TextInputEditText tifullName    = (TextInputEditText) findViewById(R.id.tiFullName);
        DatePicker datePicker           = (DatePicker) findViewById(R.id.dpDatePicker);
        TextInputEditText tiPhone       = (TextInputEditText) findViewById(R.id.tiPhone);
        TextInputEditText tiEmail       = (TextInputEditText) findViewById(R.id.tiEmail);
        TextInputEditText tiDetail      = (TextInputEditText) findViewById(R.id.tiContactDetail);
        String birhtDate = new String(Integer.toString(datePicker.getDayOfMonth())  +'/'
                +Integer.toString(datePicker.getMonth())    +'/'
                +Integer.toString(datePicker.getYear()));

        myContact = new Contact(tifullName.getText().toString(),birhtDate,tiPhone.getText().toString(),
                tiEmail.getText().toString(),tiDetail.getText().toString());
    }
}
