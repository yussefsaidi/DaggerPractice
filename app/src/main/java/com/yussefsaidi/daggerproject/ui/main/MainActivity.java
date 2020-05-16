package com.yussefsaidi.daggerproject.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yussefsaidi.daggerproject.BaseActivity;
import com.yussefsaidi.daggerproject.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
    }


}
