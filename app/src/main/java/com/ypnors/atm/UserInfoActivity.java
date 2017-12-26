package com.ypnors.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {


    private int i;
    private String TAG;
    private Spinner ages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);
       // ArrayList<String> data=new ArrayList<>();
      //  for (i = 15;i<=40;i++){
          //  data.add(i+"");
       // }
        String[] data =getResources().getStringArray(R.array.aaa);
        ArrayAdapter adapter =ArrayAdapter.createFromResource(
                this,R.array.aaa,android.R.layout.simple_list_item_1);
        ages.setAdapter(adapter);
    }

    public void addr(View view){
        startActivity(new Intent(this,CityActivity.class));
    }

    public void ok(View view){
        Log.d(TAG,"ok:"+ages.getSelectedItem().toString());
        int age =Integer.parseInt(ages.getSelectedItem().toString());
        EditText edNickname=(EditText)findViewById(R.id.user_nickname);
        EditText edPhone=(EditText)findViewById(R.id.user_phone);
        String nickname =edNickname.getText().toString();
        String phone =edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME",nickname);
        getIntent().putExtra("EXTRA_Phone",phone);
        setResult(RESULT_OK,getIntent());
        finish();
    }

    public void map(View view){

    }
}
