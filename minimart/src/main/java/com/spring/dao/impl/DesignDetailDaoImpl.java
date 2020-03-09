package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.DesignDetailDao;
import com.spring.marcom174.model.DesignDetailModel;

@Repository
public class DesignDetailDaoImpl implements DesignDetailDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(designDetailModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DesignDetailModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select dd from DesignDetailModel dd";
		
		List<DesignDetailModel> designDetailModelList = new ArrayList<DesignDetailModel>();
		designDetailModelList = session.createQuery(query).list();
		return designDetailModelList;
	}

	@Override
	public DesignDetailModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select dd from DesignDetailModel dd where dd.id="+id+"";
		
		DesignDetailModel designDetailModelList = new DesignDetailModel();
		designDetailModelList = (DesignDetailModel) session.createQuery(query).getSingleResult();
		return designDetailModelList;
	}

	@Override
	public void delete(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(designDetailModel);
	}

	@Override
	public void update(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(designDetailModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DesignDetailModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select dd from DesignDetailModel dd";
		
		List<DesignDetailModel> designDetailModelList = new ArrayList<DesignDetailModel>();
		designDetailModelList = session.createQuery(query).list();
		return designDetailModelList;
	}

	
}
