package com.ypnors.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG =CityActivity.class.getSimpleName();
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city=(ListView)findViewById(R.id.city);
        String[] cities={"新北市","基隆市","台北市"};
        ArrayAdapter adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,cities);
        city.setAdapter(adapter);
        city.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG,"onItemClick:"+position+"/"+cities[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
