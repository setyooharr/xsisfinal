package com.spring.marcom174.dao;

import java.util.List;

import com.spring.marcom174.model.EventModel;

public interface EventDao {
	public void create(EventModel eventModel);
	public List<EventModel> select();
	public EventModel searchbyId(Integer id);
	public void delete(EventModel eventModel);
	public void update(EventModel eventModel);
	
	public List<EventModel> selectNotDelete();
}
