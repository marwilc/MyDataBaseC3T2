package com.marwilc.mydatabase;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ConfirmActivity extends AppCompatActivity {

    private SwipeRefreshLayout sfiMyIndicatorRefresh;
    private ListView lstMyList;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle parameters = getIntent().getExtras();

        sfiMyIndicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.srlIndicatorRefresh);
        lstMyList = (ListView) findViewById(R.id.lstListView);
        addButtonEdit();

        String[] data = getResources().getStringArray(R.array.data);

        data[0] = data[0].concat(" ").concat(parameters.getString("fullName"));
        data[1] = data[1].concat(" ").concat(parameters.getString("birthDate"));
        data[2] = data[2].concat(" ").concat(parameters.getString("phone"));
        data[3] = data[3].concat(" ").concat(parameters.getString("email"));
        data[4] = data[4].concat(" ").concat(parameters.getString("detail"));

        lstMyList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,data));
        sfiMyIndicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
               refreshContent();
            }
        });
    }

    public void refreshContent(){
        String[] data = getResources().getStringArray(R.array.data);
        lstMyList.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,data));
        sfiMyIndicatorRefresh.setRefreshing(false);
    }

    public void addButtonEdit(){
       Button myButtonEdit = (Button) findViewById(R.id.btnEdit);
        myButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
