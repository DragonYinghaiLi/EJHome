package com.okami.apps.ej.bean.extend;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.bean.Customer;

public class AddressExtend extends Address {


    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
