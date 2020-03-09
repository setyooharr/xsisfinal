package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.CompanyModel;

public interface CompanyDao {
	
	public void create(CompanyModel companyModel);
	public List<CompanyModel> select();
	public CompanyModel searchById(Integer id);
	public void delete(CompanyModel companyModel);
	public void update(CompanyModel companyModel);
}
