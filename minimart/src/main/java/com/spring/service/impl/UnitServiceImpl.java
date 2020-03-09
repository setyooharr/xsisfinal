package com.spring.marcom174.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.marcom174.dao.UnitDao;
import com.spring.marcom174.model.UnitModel;
import com.spring.marcom174.service.UnitService;

@Service
@Transactional
public class UnitServiceImpl implements UnitService{
	
	@Autowired
	private UnitDao unitDao;
	
	@Override
	public void create(UnitModel unitModel) {
		// TODO Auto-generated method stub
		this.unitDao.create(unitModel);
	}

	@Override
	public List<UnitModel> select() {
		// TODO Auto-generated method stub
		return this.unitDao.select();
	}

}
