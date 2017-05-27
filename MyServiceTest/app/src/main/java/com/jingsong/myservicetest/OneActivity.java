package com.jingsong.myservicetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneActivity extends Activity {

    public static OneActivity oneActivity;

    Button btn_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        btn_02 = (Button) findViewById(R.id.btn_02);
        oneActivity = this;

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });


    }
}
