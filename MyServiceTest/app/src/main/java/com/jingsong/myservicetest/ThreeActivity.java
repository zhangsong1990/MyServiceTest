package com.jingsong.myservicetest;

import android.app.Activity;
import android.os.Bundle;

public class ThreeActivity extends Activity {

    public static ThreeActivity threeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        threeActivity = this;
    }

}
