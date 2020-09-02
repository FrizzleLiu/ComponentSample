package com.frizzle.componentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.frizzle.annotation.ARouter;
import com.frizzle.annotation.model.RouterBean;
import com.frizzle.api.core.ARouterLoadGroup;
import com.frizzle.api.core.ARouterLoadPath;
import com.frizzle.modular.apt.ARouter$$Group$$app;
import com.frizzle.modular.apt.ARouter$$Group$$order;
import com.frizzle.modular.apt.ARouter$$Path$$order;

import java.util.Map;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    private Button jumpOrder;
    private Button jumpPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void jumpOrder() {
        ARouterLoadGroup group = new ARouter$$Group$$order();
        Map<String, Class<? extends ARouterLoadPath>> map = group.loadGroup();
        // 通过order组名获取对应路由路径对象
        Class<? extends ARouterLoadPath> clazz = map.get("order");

        try {
            // 类加载动态加载路由路径对象
            ARouter$$Path$$order path = (ARouter$$Path$$order) clazz.newInstance();
            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取目标对象封装
            RouterBean bean = pathMap.get("/order/Order_MainActivity");

            if (bean != null) {
                Intent intent = new Intent(this, bean.getClazz());
                intent.putExtra("name", "simon");
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jumpPersonal() {
    }
}