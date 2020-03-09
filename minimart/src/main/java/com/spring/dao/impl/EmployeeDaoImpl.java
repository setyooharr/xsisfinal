package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.EmployeeDao;
import com.spring.marcom174.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void create(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employeeModel);
	}

	@Override
	public EmployeeModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select e from EmployeeModel e where e.id="+id+"";
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel = (EmployeeModel) session.createQuery(query).getSingleResult();
		
		return employeeModel;
	}

	@Override
	public void delete(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(employeeModel);
	}

	@Override
	public void update(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employeeModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select e from EmployeeModel e";
		
		List<EmployeeModel> employeeModelList = new ArrayList<EmployeeModel>();
		employeeModelList = session.createQuery(query).list();
		
		return employeeModelList;
	}
	
}
