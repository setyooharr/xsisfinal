package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.SouvenirModel;

public interface SouvenirService {
	
	public void create (SouvenirModel souvenirModel);
	public List<SouvenirModel> select();
	public SouvenirModel searchbyId(Integer id);
	public void update(SouvenirModel souvenirModel);
	public void delete (SouvenirModel souvenirModel);

	public List<SouvenirModel> selectNotDelete();
}

