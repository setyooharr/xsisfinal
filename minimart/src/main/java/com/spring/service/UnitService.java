package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.UnitModel;

public interface UnitService {

	public void create (UnitModel unitModel);
	public List<UnitModel> select();
}
