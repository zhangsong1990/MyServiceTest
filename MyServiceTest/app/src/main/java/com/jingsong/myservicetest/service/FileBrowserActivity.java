package com.jingsong.myservicetest.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jingsong.myservicetest.MainActivity;
import com.jingsong.myservicetest.OneActivity;
import com.jingsong.myservicetest.R;
import com.jingsong.myservicetest.ThreeActivity;
import com.jingsong.myservicetest.TwoActivity;

public class FileBrowserActivity extends Activity {
    Button btn_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browser);
        btn_service = (Button) findViewById(R.id.btn_service);

        btn_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (OneActivity.oneActivity != null) {

                    OneActivity.oneActivity.finish();
                }

                if (TwoActivity.twoActivity != null) {

                    TwoActivity.twoActivity.finish();
                }

                if (ThreeActivity.threeActivity != null) {

                    ThreeActivity.threeActivity.finish();
                }


                Intent intent = new Intent(FileBrowserActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
