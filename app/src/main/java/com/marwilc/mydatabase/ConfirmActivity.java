package com.marwilc.mydatabase;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConfirmActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMyIndicatorRefresh;
    ListView lstMyList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        sfiMyIndicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.srlIndicatorRefresh);
        lstMyList = (ListView) findViewById(R.id.lstListView);

        String[] data = getResources().getStringArray(R.array.data);

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
}
