package com.evertour.model.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertour.model.DAO.GuideReviewDAO;
import com.evertour.model.DMO.GuideReviewTO;


@Repository
public class GuideReviewDAOImpl implements GuideReviewDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public GuideReviewDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		System.out.println("GuideReviewDAOImpl bean created!!!!");
	}
	
	
	public Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GuideReviewTO> getAllReviews() {
		return (List<GuideReviewTO>)(currentSession().createCriteria(GuideReviewTO.class).list());
	}

}
