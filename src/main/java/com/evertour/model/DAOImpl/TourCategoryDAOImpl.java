package com.evertour.model.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertour.model.DAO.TourCategoryDAO;
import com.evertour.model.DMO.TourCategoryTO;

@Repository
public class TourCategoryDAOImpl implements TourCategoryDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public TourCategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	public Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TourCategoryTO> getAllCategories() {
		return (List<TourCategoryTO>)(currentSession().createCriteria(TourCategoryTO.class).list());
	}//end of getAllCategories

}
