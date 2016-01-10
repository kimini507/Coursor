package com.coursor.app.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.coursor.app.model.BaseBean;

public interface BaseDao<T extends BaseBean>{
    public T save(T t);
    public T saveOrUpdate(T t);
    void delete(T t);
    T findById(Long id);
    public List<T> findAll();
    public Session getSession();
}
