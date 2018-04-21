package com.temelt.arizatakip.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.temelt.arizatakip.entity.Cagri;
import com.temelt.arizatakip.entity.Kullanici;

/**
 * 
 * @author taner.temel
 *
 */
public class CagriService implements IService<Cagri> {

	@Override
	public boolean save(Cagri entity) throws Exception {
		baseDao.save(entity);
		return false;
	}

	@Override
	public boolean update(Cagri entity) {
		baseDao.update(entity);
		return false;
	}

	@Override
	public boolean delete(Cagri entity) {
		baseDao.delete(entity);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cagri> getAll(String query) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici.class);
		if (query != null) {
			criteria.add(Restrictions.ilike("baslik", query, MatchMode.ANYWHERE));
		}
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	@Override
	public Cagri getById(Long id) {
		return (Cagri) baseDao.getById(Cagri.class, id);
	}

}
