package com.evertour.model.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertour.model.DAO.GuidesDAO;
import com.evertour.model.DMO.Guide;

@Repository
public class GuideDAOImpl implements GuidesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	private final String GET_GUIDES_BY_NAME="from Guide where userName = :name";
	
	
	public GuideDAOImpl(){}//end of constructor
	
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> getAllGuides() {
		//Query q = currentSession().createQuery("");
		return (List<Guide>) currentSession().createCriteria(Guide.class).list();
	}



	@SuppressWarnings("unchecked")
	@Override
	public Guide getGuideByUserName(String userName) {
		Query q = currentSession().createQuery(GET_GUIDES_BY_NAME);
		q.setParameter("name", userName);
		List<Guide> res = (List<Guide>) q.list();
		return res.size() ==1? res.get(0):null;
	}





	@Override
	public void registerGuide(Guide guide) {
		currentSession().save(guide);
	}
	
	
	
}//end of class
