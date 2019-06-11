package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.bean.CustomerExample;
import com.okami.apps.ej.dao.CustomerMapper;
import com.okami.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 顾客
 */
@Service
public class CustomerServiceImpl implements ICustomerService {
 @Resource
    private CustomerMapper customerMapper;

    /**
     * 查询全部顾客
     * @return
     */
    @Override
    public List<Customer> findAll() {
        CustomerExample example=new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Customer findById(long id) {
        //调用dao层代码完成操作
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 模糊查询
     * @param customer
     * @return
     */
    @Override
    public List<Customer> query(Customer customer){
        return customerMapper.query(customer);
    }
    /***
     * 添加顾客
     * @param customer
     * @throws Exception
     */
    @Override
    public void save(Customer customer) throws Exception{
        if(customer.getId()==null){
            customerMapper.insert(customer);
        }else{
            System.out.println("用户已存在");
        }
    }

    /***
     * 修改操作
     * @param customer
     * @throws Exception
     */
    @Override
    public  void update(Customer customer) throws Exception{
           customerMapper.updateByPrimaryKeySelective(customer);
    }


    /***
     * 删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(long id) throws Exception {
        Customer customer=customerMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除顾客不存在");
        }else{
            customerMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 批量删除
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            customerMapper.deleteByPrimaryKey(id);
        }
    }

}
