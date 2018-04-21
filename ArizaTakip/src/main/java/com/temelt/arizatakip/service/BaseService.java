package com.temelt.arizatakip.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author taner.temel
 *
 */
@SuppressWarnings("rawtypes")
public class BaseService {

	public boolean save(Object entity) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction trans = session.beginTransaction();
			session.save(entity);
			trans.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Object entity) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction trans = session.beginTransaction();
			session.update(entity);
			trans.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Object entity) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction trans = session.beginTransaction();
			session.delete(entity);
			trans.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public List getAll(Class cls, String query) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(cls);
		List list = criteria.list();
		session.close();
		return list;
	}

	public Object getById(Class cls, Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(cls);
		criteria.add(Restrictions.eq("id", id));
		Object o = criteria.uniqueResult();
		session.close();
		return o;
	}

}
