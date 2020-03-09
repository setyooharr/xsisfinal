package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.EmployeeDao;
import com.spring.marcom174.model.EmployeeModel;
import com.spring.marcom174.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void create(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		this.employeeDao.create(employeeModel);
	}

	@Override
	public List<EmployeeModel> select() {
		// TODO Auto-generated method stub
		return this.employeeDao.select();
	}

	@Override
	public EmployeeModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.employeeDao.searchById(id);
	}

	@Override
	public void delete(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		this.employeeDao.delete(employeeModel);
	}

	@Override
	public void update(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		this.employeeDao.update(employeeModel);
	}
		
}
