package com.ypnors.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_USERINFO =105 ;
    boolean logon =false;
   public static final int REQUEST_LOGIN=102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startActivity(new Intent(this,Ch8Activity.class));
        if(!logon){
            Intent intent =new Intent(this,LoginActivity.class);
            startActivityForResult(intent,REQUEST_LOGIN);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener((view) {
            Intent userinfo=new Intent(MainActivity.this, UserInfoActivity.class);
            startActivityForResult(userinfo,REQUEST_USERINFO);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:  {
                if(resultCode == RESULT_OK){
                    String uid=data.getStringExtra("EXTRA_USERID");
                    Toast.makeText(this,"Login userid:"+uid,Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm",MODE_PRIVATE)
                            .edit()
                            .putString("USERID",uid)
                            .apply();
                }
                else {
                    finish();
            }
       break;
                case REQUEST_USERINFO:
                    if(resultCode ==RESULT_OK){
                        String nickname =data.getStringExtra("EXTRA_NICKNAME");
                        String phone =data.getStringExtra("EXTRA_PHONE");
                        Toast.makeText(this,"Nickname"+nickname,Toast.LENGTH_LONG).show();
                        Toast.makeText(this,"Phone"+phone,Toast.LENGTH_LONG).show();
                        getSharedPreferences("atm",MODE_PRIVATE)
                                .edit()
                                .putString("ID",)
                                .apply();
                    }
                    break;
        }
    }

            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setContentView(R.layout.activity_login);
        getSharedPreferences("atm",MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
