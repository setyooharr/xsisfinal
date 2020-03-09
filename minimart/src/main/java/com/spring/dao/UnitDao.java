package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.UnitModel;

public interface UnitDao {
	
	public void create (UnitModel unitModel);
	public List<UnitModel> select();

}
