package com.frizzle.modular.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.frizzle.annotation.ARouter;

@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
    }
}
