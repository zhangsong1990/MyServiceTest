package com.jingsong.myservicetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TwoActivity extends Activity {
    public static TwoActivity twoActivity;

    Button btn_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        twoActivity = this;

        btn_03 = (Button) findViewById(R.id.btn_03);
        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
                startActivity(intent);
            }
        });


    }

}
