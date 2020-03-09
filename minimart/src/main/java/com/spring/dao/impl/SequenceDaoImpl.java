package com.spring.marcom174.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.marcom174.dao.SequenceDao;
import com.spring.marcom174.model.SequenceModel;

@Repository
public class SequenceDaoImpl implements SequenceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer nextIdRole() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idRole = 0;
		String query = "from SequenceModel where sequenceName='M_ROLE_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idRole = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idRole = 1;
		}
		return idRole;
	}

	@Override
	public Integer nextIdUser() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idUser = 0;
		String query = "from SequenceModel where sequenceName='M_USER_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idUser = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idUser = 1;
		}
		return idUser;
	}

	@Override
	public Integer nextIdEvent() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idEvent = 0;
		String query = "from SequenceModel where sequenceName='T_EVENT_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idEvent = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idEvent = 1;
		}
		return idEvent;
	}

	@Override
	public Integer nextIdCompany() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idCompany = 0;
		String query = "from SequenceModel where sequenceName='M_COMPANY_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idCompany = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idCompany = 1;
		}
		return idCompany;
	}

	@Override
	public Integer nextIdDesign() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idDesign = 0;
		String query = "from SequenceModel where sequenceName='T_DESIGN_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idDesign = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idDesign = 1;
		}
		return idDesign;
	}

	@Override
	public Integer nextIdProduct() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idProduct = 0;
		String query = "from SequenceModel where sequenceName='M_PRODUCT_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idProduct = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idProduct = 1;
		}
		return idProduct;
	}

	@Override
	public Integer nextIdMenu() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idMenu = 0;
		String query = "from SequenceModel where sequenceName='M_MENU_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idMenu = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idMenu = 1;
		}
		return idMenu;
	}

	@Override
	public Integer nextIdUnit() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idUnit = 0;
		String query = "from SequenceModel where sequenceName='M_UNIT_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idUnit = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idUnit = 1;
		}
		return idUnit;
	}

	@Override
	public Integer nextIdSouvenir() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idSouvenir = 0;
		String query = "from SequenceModel where sequenceName='M_SOUVENIR_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idSouvenir = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idSouvenir = 1;
		}
		return idSouvenir;
	}

}
