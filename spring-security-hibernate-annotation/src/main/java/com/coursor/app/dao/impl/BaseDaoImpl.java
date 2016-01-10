package com.coursor.app.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coursor.app.dao.BaseDao;
import com.coursor.app.model.BaseBean;

@Repository
public abstract class BaseDaoImpl<T extends BaseBean> implements BaseDao<T> {
    
	private Class<T> clazz;
	
    @Autowired
    private SessionFactory sessionFactory;
    { initClazz(); }
    
    @SuppressWarnings("unchecked")
    private void initClazz(){
    	this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public Class<T> getClazz(){
    	return this.clazz;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T save(T obj) {
        getSession().persist(obj);
        return obj;
    }

    @Override
    public T saveOrUpdate(T t) {
    	getSession().merge(t);
    	return null;
    }
    
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }
    
    @Override
    public T findById(Long id) {
    	return (T)getSession().get(getClazz(), id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
    	List<T> l = getSession().createCriteria(getClazz()).list();
    	return l;
    }
}
