package com.ypnors.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

    public void ok(View view){
        EditText edNickname=(EditText)findViewById(R.id.user_nickname);
        EditText edPhone=(EditText)findViewById(R.id.user_phone);
        String nickname =edNickname.getText().toString();
        String phone =edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME",nickname);
        getIntent().putExtra("EXTRA_Phone",phone);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
