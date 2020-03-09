package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.UserModel;

public interface UserService {
	public void create(UserModel userModel);
	public List<UserModel> select();
	public UserModel searchById(Integer id);
	public void delete(UserModel userModel);
	public void update(UserModel userModel);
	
	public UserModel searchByUsernamePassword(String username, String password);
	public List<UserModel> selectNotDelete();
	
}
