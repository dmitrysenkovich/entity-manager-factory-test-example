package com.bug.example.dao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.annotation.Resource;

@Component
public class Dao {

    @Resource
    SessionFactory sessionFactory;

    public <T> Serializable save(T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    public void flushAndClearSession() {
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

}
