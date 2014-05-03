package net.javaloping.ourtaskr.business.dao;

import java.io.Serializable;

/**
 * @author victormiranda
 */

public interface GenericDao< T > {

	void delete(T t);

	T get(Serializable pk);

	T save(T t);

}