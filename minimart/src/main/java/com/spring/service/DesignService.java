package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.DesignModel;

public interface DesignService {

	public void create(DesignModel designModel);
	public List<DesignModel> select();
	public DesignModel searchById(Integer id);
	public void delete(DesignModel designModel);
	public void update(DesignModel designModel);
	public List<DesignModel> selectNotDelete();
}
