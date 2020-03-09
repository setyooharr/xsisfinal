package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.DesignDao;
import com.spring.marcom174.model.DesignModel;

@Repository
public class DesignDaoImpl implements DesignDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(DesignModel designModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(designModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DesignModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select d from DesignModel d";
		
		List<DesignModel> designModelList = new ArrayList<DesignModel>();
		designModelList = session.createQuery(query).list();
		return designModelList;
	}

	@Override
	public DesignModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select d from DesignModel d where d.id="+id+"";
		
		DesignModel designModelList = new DesignModel();
		designModelList = (DesignModel) session.createQuery(query).getSingleResult();
		return designModelList;
	}

	@Override
	public void delete(DesignModel designModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(designModel);
	}

	@Override
	public void update(DesignModel designModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(designModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DesignModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select dd from DesignModel dd";
		
		List<DesignModel> designModelList = new ArrayList<DesignModel>();
		designModelList = session.createQuery(query).list();
		return designModelList;
	}

	
}
