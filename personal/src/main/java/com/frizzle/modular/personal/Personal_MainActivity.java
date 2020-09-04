package com.frizzle.modular.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.frizzle.annotation.ARouter;
import com.frizzle.api.RouterManager;

@ARouter(path = "/personal/Personal_MainActivity")
public class Personal_MainActivity extends AppCompatActivity {

    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
        btnFinish = findViewById(R.id.btn_finish);
        String from = getIntent().getStringExtra("from");
        if (!TextUtils.isEmpty(from)){
            Log.e("Frizzle",from);
        }
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //携带参数返回app主界面
                RouterManager.getInstance()
                        .build("/app/MainActivity")
                        .withResultString("back","Personal携带参数返回")
                        .navigation(Personal_MainActivity.this);
            }
        });
    }
}
