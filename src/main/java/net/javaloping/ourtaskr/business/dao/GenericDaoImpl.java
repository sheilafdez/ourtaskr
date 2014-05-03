package net.javaloping.ourtaskr.business.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author victormiranda
 */

public abstract class GenericDaoImpl< T > implements GenericDao< T > {

	@Autowired
	private SessionFactory sessionFactory;

	/** clazz */
	private Class<T> clazz;

	public GenericDaoImpl() {
	}

	public GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T get(Serializable pk) {
		return (T)getSession().get(clazz, pk);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@Override
	public T save(T t) {
		getSession().persist(t);
		return t;
	}
}