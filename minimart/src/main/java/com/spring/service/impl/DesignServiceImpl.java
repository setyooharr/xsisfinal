package com.spring.marcom174.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.marcom174.dao.DesignDao;
import com.spring.marcom174.model.DesignModel;
import com.spring.marcom174.service.DesignService;

@Service
@Transactional
public class DesignServiceImpl implements DesignService {

	@Autowired
	private DesignDao designRequestDao;
	@Override
	public void create(DesignModel designModel) {
		// TODO Auto-generated method stub
		this.designRequestDao.create(designModel);
	}

	@Override
	public List<DesignModel> select() {
		// TODO Auto-generated method stub
		return this.designRequestDao.select();
	}

	@Override
	public DesignModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.designRequestDao.searchById(id);
	}

	@Override
	public void delete(DesignModel designModel) {
		// TODO Auto-generated method stub
		this.designRequestDao.delete(designModel);
	}

	@Override
	public void update(DesignModel designModel) {
		// TODO Auto-generated method stub
		this.designRequestDao.update(designModel);
	}

	@Override
	public List<DesignModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.designRequestDao.selectNotDelete();
	}

	
}