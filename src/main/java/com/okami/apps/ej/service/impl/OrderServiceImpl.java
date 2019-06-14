package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.OrderLine;
import com.okami.apps.ej.bean.extend.OrderExtend;
import com.okami.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.okami.apps.ej.bean.vm.OrderVM;
import com.okami.apps.ej.dao.OrderLineMapper;
import com.okami.apps.ej.dao.extend.OrderExtendMapper;
import com.okami.apps.ej.service.IOrderService;
import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.OrderExample;
import com.okami.apps.ej.dao.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/***
 * 订单接口实现
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Resource
    private OrderLineMapper orderLineMapper;

    @Override
    public List<OrderVM> queryBasic(Long customerId, Long waiterId) {
        return orderExtendMapper.queryBasic(customerId, waiterId);
    }

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
     * 关联查询
     */
    @Override
    public List<OrderExtend> query(Long customerId, Long waiterId) {
        return orderExtendMapper.query(customerId,waiterId);
    }
    /**

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
    public void insertOrder(OrderAndOrderLineVM order) throws Exception {
        //先保存订单
        Order o = new Order();
        o.setOrderTime(new Date().getTime());
        o.setTotal(100.0);
        o.setCustomerId(order.getCustomerId());
        o.setAddressId(order.getAddressId());
        orderMapper.insert(o);
        // 再保存订单项
        List<OrderLine> list = order.getOrderLines();
        for(OrderLine ol : list){
            // 维护订单项与订单之间的关系
            ol.setOrderId(o.getId());
            orderLineMapper.insert(ol);
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