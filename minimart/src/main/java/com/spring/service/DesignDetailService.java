package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.DesignDetailModel;

public interface DesignDetailService {

	public void create(DesignDetailModel designDetailModel);
	public List<DesignDetailModel> select();
	public DesignDetailModel searchById(Integer id);
	public void delete(DesignDetailModel designDetailModel);
	public void update(DesignDetailModel designDetailModel);
	public List<DesignDetailModel> selectNotDelete();
}
