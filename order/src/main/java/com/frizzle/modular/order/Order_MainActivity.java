package com.frizzle.modular.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.frizzle.annotation.ARouter;

@ARouter(path = "/order/Order_MainActivity")
public class Order_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
    }
}
