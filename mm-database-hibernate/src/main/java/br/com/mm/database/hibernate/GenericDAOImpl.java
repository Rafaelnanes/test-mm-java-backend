package br.com.mm.database.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.mm.dao.GenericDAO;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
	Session session = null;
	try {
	    session = sessionFactory.getCurrentSession();
	} catch (HibernateException e) {
	    session = sessionFactory.openSession();
	}
	return session;
    }

    @Override
    public T add(T obj) {
	getSession().save(obj);
	getSession().refresh(obj);
	return obj;
    }

    protected abstract Class<T> getPersistenceClass();
}
