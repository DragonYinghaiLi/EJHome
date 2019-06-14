package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Waiter;

import java.util.List;

public interface IWaiterService {
    List<Waiter> findAll();
    void deleteById(long id) throws Exception;
}
