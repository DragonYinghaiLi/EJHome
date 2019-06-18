package com.okami.apps.ej.bean.extend;

import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.bean.Order;

/**
 * @Author: Li
 * @Date: 2019/6/17 21:55
 * @Description:
 */
public class CommentExtend extends Comment {
    private Order order;
    public  Order getOrder() {return  order;}
    public  void  setOrder(Order order){this.order = order;}
}
