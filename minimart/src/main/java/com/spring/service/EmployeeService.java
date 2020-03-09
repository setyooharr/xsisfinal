package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.EmployeeModel;

public interface EmployeeService {
	
	public void create(EmployeeModel employeeModel);
	public List<EmployeeModel> select();
	public EmployeeModel searchById(Integer id);
	public void delete(EmployeeModel employeeModel);
	public void update(EmployeeModel employeeModel);
}
