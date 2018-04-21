package com.temelt.arizatakip.service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.temelt.arizatakip.entity.Demirbas;
import com.temelt.arizatakip.entity.Kullanici;

public class DemirbasService implements IService<Demirbas> {

	@Override
	public boolean save(Demirbas entity) throws Exception {
		baseDao.save(entity);
		return false;
	}

	@Override
	public boolean update(Demirbas entity) {
		baseDao.update(entity);
		return false;
	}

	@Override
	public boolean delete(Demirbas entity) {
		baseDao.delete(entity);
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demirbas> getAll(String query) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici.class);
		if (query != null) {
			criteria.add(Restrictions.ilike("adi", query, MatchMode.ANYWHERE));
		}
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	@Override
	public Demirbas getById(Long id) {
		return (Demirbas) baseDao.getById(Demirbas.class, id);
	}

}
