package com.spring.marcom174.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.marcom174.dao.DesignDetailDao;
import com.spring.marcom174.model.DesignDetailModel;
import com.spring.marcom174.service.DesignDetailService;

@Service
@Transactional
public class DesignDetailServiceImpl implements DesignDetailService {

	@Autowired
	private DesignDetailDao designDetailDao;
	@Override
	public void create(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		this.designDetailDao.create(designDetailModel);
	}

	@Override
	public List<DesignDetailModel> select() {
		// TODO Auto-generated method stub
		return this.designDetailDao.select();
	}

	@Override
	public DesignDetailModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return this.designDetailDao.searchById(id);
	}

	@Override
	public void delete(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		this.designDetailDao.delete(designDetailModel);
	}

	@Override
	public void update(DesignDetailModel designDetailModel) {
		// TODO Auto-generated method stub
		this.designDetailDao.update(designDetailModel);
	}

	@Override
	public List<DesignDetailModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.designDetailDao.selectNotDelete();
	}

	
}
