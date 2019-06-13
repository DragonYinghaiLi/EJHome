package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.service.IOrderService;
import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.OrderExample;
import com.okami.apps.ej.dao.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 订单接口实现
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    /***
     * 查询全部
     * @return
     */
    @Override
    public List<Order> findAllOrder() {
        //创建空模块
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Order findOrderById(long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    /***
     * 模糊查询
     * @param order
     * @return
     */
    @Override
    public List<Order> queryOrder(Order order) {
        // 创建空模板
        OrderExample example = new OrderExample();
        // 在模板中添加条件
        if(order.getId()!=null){
            example.createCriteria().andIdEqualTo(order.getId());
        }
        if(order.getAddressId()!=null){
            example.createCriteria().andAddressIdEqualTo(order.getAddressId());
        }
        if(order.getCustomerId()!=null){
            example.createCriteria().andCustomerIdEqualTo(order.getAddressId());
        }
        if(order.getWaiterId()!=null){
            example.createCriteria().andWaiterIdEqualTo(order.getWaiterId());
        }
        if(order.getOrderTime()!=null){
            example.createCriteria().andOrderTimeEqualTo(order.getOrderTime());
        }
        if(order.getTotal()!=null){
            example.createCriteria().andTotalEqualTo(order.getTotal());
        }

        return orderMapper.selectByExample(example);
    }

    /***
     *插入
     * @param order
     * @throws Exception
     */
    @Override
    public void insertOrder(Order order) throws Exception {
        Order orderLine1=orderMapper.selectByPrimaryKey(order.getId());
        if(orderLine1==null){
            orderMapper.insert(order);
        }else{
            throw new Exception("id已存在");
        }

    }

    /***
     * 修改
     * @param order
     * @throws Exception
     */
    @Override
    public void updateOrderPrimaryKey(Order order) throws Exception {
        Order order1=orderMapper.selectByPrimaryKey(order.getId());
        if(order1==null){
            throw new Exception("要修改的订单项不存在！");
        }else{
            orderMapper.updateByPrimaryKeySelective(order);
        }
    }

    /***
     * 根据id删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteOrderById(long id) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new Exception("要删除的订单不存在");
        } else {
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    /***
     * 批量删除
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDeleteOrder(long[] ids) throws Exception {
        for(long id : ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}