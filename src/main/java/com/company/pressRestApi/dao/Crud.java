package com.company.pressRestApi.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class Crud<T>{

    protected EntityManager entityManager;

    @Autowired
    public Crud(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<T> getAll(String tableName, Class<T> tClass ) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<T> theQuery = currentSession.createQuery("from " + tableName, tClass);
        return theQuery.getResultList();
    }

    public T getById(int id, Class<T> tClass ) {
        return entityManager.find(tClass, id);
    }

    public boolean create(T  object) {
        Session currentSession = entityManager.unwrap(Session.class);
        try {
            currentSession.save(object);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(T  object) {
        Session currentSession = entityManager.unwrap(Session.class);
        try {
            currentSession.update(object);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(T object) {
        Session currentSession = entityManager.unwrap(Session.class);
        try {
            currentSession.delete(object);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
