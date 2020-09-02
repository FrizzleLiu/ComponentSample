package com.frizzle.api.core;

import java.util.Map;

/**
 * author: LWJ
 * date: 2020/8/31$
 * description
 * 路由组Group对外提供加载数据的接口
 */
public interface ARouterLoadGroup {
    /**
     * 加载路由组Group数据
     * 比如："app", ARouter$$Path$$app.class（实现了ARouterLoadPath接口）
     *
     * @return key:"app", value:"app"分组对应的路由详细对象类
     */
    Map<String,Class<? extends ARouterLoadPath>> loadGroup();
}
