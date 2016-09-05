package com.example.wzb97.sharedpreference_homework17;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName = "config";

    //键
    private final static String Key_UserSno = "UserSno";//学号
    private final static String Key_UserName = "UserName";//姓名
    private final static String Key_UserAge = "UserAge";//年龄

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor = preferences.edit();

        Button btnWrite = (Button) findViewById(R.id.button);
        Button btnRead = (Button) findViewById(R.id.button2);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Key_UserSno, "2014011400");
                editor.putString(Key_UserName, "科科");
                editor.putInt(Key_UserAge, 19);

                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserSno = preferences.getString(Key_UserSno, null);
                String strUserName = preferences.getString(Key_UserName, null);
                int nUserAge = preferences.getInt(Key_UserAge, 0);
                if (strUserSno != null && strUserName != null)
                    Toast.makeText(MainActivity.this, "学号:" + strUserSno + "姓名:" + strUserName + "年龄:" + nUserAge, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}
