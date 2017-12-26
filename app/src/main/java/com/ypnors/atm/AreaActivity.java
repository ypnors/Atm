package com.ypnors.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG =CityActivity.class.getSimpleName();
    private String[] areas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView area =(ListView)findViewById(R.id.area);
        String[] areas={"信義區","大安區","士林區"};
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
        area.setAdapter(adapter);
        area.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d(TAG,"onItemClick"+position+"/"+areas[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
