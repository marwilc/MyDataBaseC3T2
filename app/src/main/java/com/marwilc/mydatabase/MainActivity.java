package com.marwilc.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent myActivityConfirm;
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
                myActivityConfirm = new Intent(getApplicationContext(),ConfirmActivity.class);
                startActivity(myActivityConfirm);
            }
        });
    }
}
