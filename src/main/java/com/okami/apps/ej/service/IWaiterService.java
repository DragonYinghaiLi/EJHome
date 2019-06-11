package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Waiter;

import java.util.List;

/**
 * 服务人员
 */
public interface IWaiterService {
    List<Waiter> findAll();
    void deleteById(long id) throws Exception;
    void save(Waiter waiter) throws Exception;
    void update(Waiter waiter) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
