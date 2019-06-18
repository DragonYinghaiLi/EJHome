package com.okami.apps.ej.bean.extend;

import com.okami.apps.ej.bean.*;

import java.util.List;

public class OrderExtend extends Order {


    private Customer customer;

    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    private Waiter waiter;

    public Waiter getWaiter(){
        return waiter;
    }
    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }

    private Address address;

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines(){
        return orderLines;
    }
    public void setOrderLines(List<OrderLine> orderLines){
        this.orderLines = orderLines;
    }
}
