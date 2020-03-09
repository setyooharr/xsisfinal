package com.spring.marcom174.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.marcom174.dao.SouvenirDao;
import com.spring.marcom174.model.SouvenirModel;
import com.spring.marcom174.service.SouvenirService;

@Service
@Transactional
public class SouvenirServiceImpl implements SouvenirService{

	@Autowired
	private SouvenirDao souvenirDao;
	
	@Override
	public void create(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		this.souvenirDao.create(souvenirModel);
	}

	@Override
	public List<SouvenirModel> select() {
		// TODO Auto-generated method stub
		return this.souvenirDao.select();
	}

	@Override
	public SouvenirModel searchbyId(Integer id) {
		// TODO Auto-generated method stub
		return this.souvenirDao.searchbyId(id);
	}

	@Override
	public void update(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		this.souvenirDao.update(souvenirModel);
	}

	@Override
	public void delete(SouvenirModel souvenirModel) {
		// TODO Auto-generated method stub
		this.souvenirDao.delete(souvenirModel);
	}

	@Override
	public List<SouvenirModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.souvenirDao.selectNotDelete();
	}

}
