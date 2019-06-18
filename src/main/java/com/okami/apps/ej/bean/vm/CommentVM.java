package com.okami.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;

/**
 * @Author: Li
 * @Date: 2019/6/17 21:55
 * @Description:
 */
public class CommentVM {
    @ApiParam(value = "订单id",required = true)
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
