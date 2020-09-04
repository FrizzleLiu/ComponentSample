package com.frizzle.modular.order.impl;

import com.frizzle.annotation.ARouter;
import com.frizzle.common.order.OrderDrawable;
import com.frizzle.modular.order.R;

/**
 * author: LWJ
 * date: 2020/9/4$
 * description
 */
@ARouter(path = "/order/getDrawable")
public class OrderDrawableImpl implements OrderDrawable {
    @Override
    public int getDrawable() {
        return R.drawable.ic_mine_update;
    }
}
