package com.jingsong.myservicetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jingsong.myservicetest.service.MyService;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnStartService, btn_01;
    private Intent intent;
    EditText ed_minute, ed_hours;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
        btn_01 = (Button) findViewById(R.id.btn_01);
        ed_hours = (EditText) findViewById(R.id.ed_hours);
        ed_minute = (EditText) findViewById(R.id.ed_minute);

        btnStartService.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ed_hours.setText("");
        ed_minute.setText("");

        ed_hours.setVisibility(View.VISIBLE);
        ed_minute.setVisibility(View.VISIBLE);
        btnStartService.setVisibility(View.VISIBLE);

        Log.e("tag", "onNewIntent() * * *-  -- -");
    }

    @Override
    public void onClick(View view) {
        String tag_hours = "";
        String tag_minute = "";

        if (TextUtils.isEmpty(ed_minute.getText().toString())) {
            ed_minute.setText("");
            ed_minute.setFocusable(true);
            ed_minute.requestFocus();
            Toast.makeText(MainActivity.this, "无效时间", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(ed_hours.getText().toString())) {
            ed_hours.setText("");
            ed_hours.setFocusable(true);
            ed_hours.requestFocus();
            Toast.makeText(MainActivity.this, "无效时间", Toast.LENGTH_SHORT).show();
            return;
        }

        String trim_ed_hours = ed_hours.getText().toString().trim() == null ? " -1" : ed_hours.getText().toString().trim();
        String trim_ed_minute = ed_minute.getText().toString().trim() == null ? "-1" : ed_minute.getText().toString().trim();

        int trim_hours = Integer.parseInt(trim_ed_hours);

        int trim_minute = Integer.parseInt(trim_ed_minute);

        if (trim_hours > 0 && trim_hours < 25) { // 小时
            tag_hours = trim_ed_hours;
        } else {
            ed_hours.setText("");
            ed_hours.setFocusable(true);
            ed_hours.requestFocus();
            Toast.makeText(MainActivity.this, "无效时间", Toast.LENGTH_SHORT).show();
            return;
        }


        if (trim_minute >= 0 && trim_minute < 61) { // 分钟

            tag_minute = trim_ed_minute;

        } else {
            ed_minute.setText("");
            ed_minute.setFocusable(true);
            ed_minute.requestFocus();
            Toast.makeText(MainActivity.this, "无效时间", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()) {
            case R.id.btnStartService:

                intent = new Intent(MainActivity.this, MyService.class);
                ed_hours.setVisibility(View.INVISIBLE);
                ed_minute.setVisibility(View.INVISIBLE);
                btnStartService.setVisibility(View.INVISIBLE);

                intent.putExtra("Hour", tag_hours + "," + tag_minute);
                startService(intent);

                imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
                break;
            case R.id.btn_01:
                intent = new Intent(this, OneActivity.class);
                startActivity(intent);

                break;

        }

    }
}
