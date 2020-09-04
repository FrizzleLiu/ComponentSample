package com.frizzle.modular;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.frizzle.annotation.ARouter;
import com.frizzle.annotation.Parameter;
import com.frizzle.api.ParameterManager;
import com.frizzle.api.RouterManager;
import com.frizzle.common.order.OrderDrawable;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    private Button jumpOrder;
    private Button jumpPersonal;
    @Parameter(name = "/order/getDrawable")
    OrderDrawable drawable;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.isRelease) {
            Log.e("Frizzle", "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e("Frizzle", "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
        ParameterManager.getInstance().loadParameter(this);
        jumpOrder = (Button) findViewById(R.id.btn_jump_order);
        jumpOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpOrder();
            }
        });
        jumpPersonal = (Button) findViewById(R.id.btn_jump_personal);
        jumpPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpPersonal();
            }
        });
        image = (ImageView) findViewById(R.id.image);
        image.setImageResource(drawable.getDrawable());
    }

    public void jumpOrder() {
        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .navigation(this);
    }

    public void jumpPersonal() {
        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("from","主界面跳转")
                .navigation(this,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Log.e("frizzle",requestCode+data.getStringExtra("back"));
        }
    }
}