package com.spring.marcom174.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.EventDao;
import com.spring.marcom174.model.EventModel;


@Repository
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void create(EventModel eventModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(eventModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select e from EventModel e";
		
		List<EventModel> eventModelList = new ArrayList<EventModel>();
		eventModelList = session.createQuery(query).list();
		
		return eventModelList;
	}

	@Override
	public EventModel searchbyId(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select e from EventModel e where e.id="+id+"";
		EventModel eventModel = new EventModel();
		eventModel = (EventModel) session.createQuery(query).getSingleResult();
		
		return eventModel;
	}

	@Override
	public void delete(EventModel eventModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(eventModel);
	}

	@Override
	public void update(EventModel eventModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(eventModel);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<EventModel> selectNotDelete() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select e from EventModel e where e.isDelete = 0";
		
		List<EventModel> eventModelList = new ArrayList<EventModel>();
		eventModelList = session.createQuery(query).list();
		
		return eventModelList;
	}

}
