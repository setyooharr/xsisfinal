package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SouvenirDao;
import com.spring.marcom174.model.SouvenirModel;

@Repository
public class SouvenirDaoImpl implements SouvenirDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(souvenirModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select s from SouvenirModel s";
		
		List<SouvenirModel> souvenirModelList = new ArrayList<SouvenirModel>();
		souvenirModelList = session.createQuery(query).list();
		return souvenirModelList;
	}

	@Override
	public SouvenirModel searchbyId(Integer id) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		String query = "select s from SouvenirModel s where id ="+id+" ";
		
		SouvenirModel souvenirModel = new SouvenirModel();
		souvenirModel=(SouvenirModel) session.createQuery(query).getSingleResult();
		
		return souvenirModel;
	}

	@Override
	public void update(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(souvenirModel);
	}

	@Override
	public void delete(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(souvenirModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SouvenirModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select m from SouvenirModel m where m.xIsDelete = 0";
		
		List<SouvenirModel> souvenirModelList = new ArrayList<SouvenirModel>();
		souvenirModelList = session.createQuery(query).list();
		
		return souvenirModelList;
	}

}
