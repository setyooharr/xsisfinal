package com.spring.marcom174.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marcom174.dao.EventDao;
import com.spring.marcom174.model.EventModel;
import com.spring.marcom174.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;
	
	@Override
	public void create(EventModel eventModel) {
		// TODO Auto-generated method stub
		this.eventDao.create(eventModel);
	}

	@Override
	public List<EventModel> select() {
		// TODO Auto-generated method stub
		return this.eventDao.select();
	}

	@Override
	public EventModel searchbyId(Integer id) {
		// TODO Auto-generated method stub
		return this.eventDao.searchbyId(id);
	}

	@Override
	public void delete(EventModel eventModel) {
		// TODO Auto-generated method stub
		this.eventDao.delete(eventModel);
	}

	@Override
	public void update(EventModel eventModel) {
		// TODO Auto-generated method stub
		this.eventDao.update(eventModel);
	}


	@Override
	public List<EventModel> selectNotDelete() {
		// TODO Auto-generated method stub
		return this.eventDao.selectNotDelete();
	}

}
