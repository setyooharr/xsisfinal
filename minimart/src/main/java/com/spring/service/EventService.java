package com.spring.marcom174.service;

import java.util.List;

import com.spring.marcom174.model.EventModel;

public interface EventService {
	
	public void create(EventModel eventModel);
	public List<EventModel> select();
	public EventModel searchbyId(Integer id);
	public void delete(EventModel eventModel);
	public void update(EventModel eventModel);
	
	public List<EventModel> selectNotDelete();
}
