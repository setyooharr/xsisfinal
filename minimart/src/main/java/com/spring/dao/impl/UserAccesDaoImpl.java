package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.UserAccessDao;
import com.spring.marcom174.model.UserAccessModel;

@Repository
public class UserAccesDaoImpl implements UserAccessDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userAccessModel);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAccessModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select m from UserAccessModel m";
		List<UserAccessModel> userAccessModeList = new ArrayList<UserAccessModel>();
		userAccessModeList = session.createQuery(query).list();
		return userAccessModeList;
	}


	@Override
	public UserAccessModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "Select m from UserAccessModel m where id="+id+" ";
		UserAccessModel userAccessModel = new UserAccessModel();
		userAccessModel = (UserAccessModel) session.createQuery(query).getSingleResult();
		return userAccessModel;
	}


	@Override
	public void update(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userAccessModel);
	}


	@Override
	public void delete(UserAccessModel userAccessModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userAccessModel);
	}

}
