package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.UnitDao;
import com.spring.marcom174.model.UnitModel;

@Repository
public class UnitDaoImpl implements UnitDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(UnitModel unitModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(unitModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select u from UnitModel u";
		List<UnitModel> unitModelList = new ArrayList<UnitModel>();
		unitModelList = session.createQuery(query).list();
		return unitModelList;
	}

}
