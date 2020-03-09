package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.CompanyDao;
import com.spring.marcom174.model.CompanyModel;
import com.spring.marcom174.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	public void create(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		this.companyDao.create(companyModel);
	}

	@Override
	public List<CompanyModel> select() {
		// TODO Auto-generated method stub
		return this.companyDao.select();
	}

	@Override
	public CompanyModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.companyDao.searchById(id);
	}

	@Override
	public void delete(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		this.companyDao.delete(companyModel);
	}

	@Override
	public void update(CompanyModel companyModel) {
		// TODO Auto-generated method stub
		this.companyDao.update(companyModel);
	}
		
}
