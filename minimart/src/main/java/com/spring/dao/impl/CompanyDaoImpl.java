package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.CompanyDao;
import com.spring.marcom174.model.CompanyModel;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void create(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(companyModel);
	}

	@Override
	public CompanyModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select c from CompanyModel c where c.id="+id+"";
		
		CompanyModel companyModel = new CompanyModel();
		companyModel = (CompanyModel) session.createQuery(query).getSingleResult();
		
		return companyModel;
	}

	@Override
	public void delete(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(companyModel);
	}

	@Override
	public void update(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(companyModel);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select c from CompanyModel c";
		
		List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
		companyModelList = session.createQuery(query).list();
		
		return companyModelList;
	}
}
