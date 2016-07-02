package com.evertour.model.DAOImpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertour.model.DAO.TestTourDAO;
import com.evertour.model.DMO.Guide;
import com.evertour.model.DMO.TourTO;

@Repository
public class TestTourDAOImpl implements TestTourDAO {

	private SessionFactory sessionFactory;
	// IN HQL we use the TO classes and properties not the table names!!!!!!!
	private final String SELECT_TOUR_BY_TYPEID = " from TourTO where TYPE_ID = :typeID ";
	private final String SELECT_TOUR_BY_NAME = " from TourTO where name = :name ";
	private final String SELECT_TOUR_BY_ID = " from TourTO where id = :id ";

	@Autowired
	public TestTourDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("TestTourDAOImpl bean created!!!!");
	}

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * returns all tours
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TourTO> getAllTours() {
		List<TourTO> tours = currentSession().createCriteria(TourTO.class).list();
		/**
		 * because the many to many relation with the guides is fetched lazy, so
		 * as not to retrieve the whole database graph, we have to initialize
		 * (i.e. tell hibernate to explicitly fetch here the guides for each
		 * tour, before we return it!!!!
		 */
		for (TourTO t : tours) {
			Hibernate.initialize(t.getGuides());
		}

		return tours;
	}

	/**
	 * @param typeId
	 *            the primary key of the category of the Tour
	 * @return a list of TestTourTO that match the given category
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TourTO> getAllToursByCategory(int typeId) {
		Query q = currentSession().createQuery(SELECT_TOUR_BY_TYPEID);
		q.setParameter("typeID", typeId);
		List<TourTO> tours = q.list();
		for(TourTO tour : tours){
			Hibernate.initialize(tour.getGuides());
		}
		return tours;
	}// end of getAllToursByCategory

	/**
	 * Saves OR Updates the given tour param to the database!!!
	 * 
	 * @param tour
	 *            , a TOUR Data Model Object
	 */
	@Override
	public void addTour(TourTO tour) {
		currentSession().saveOrUpdate(tour);
	}// end of addTour

	/*
	 * returns the first tour found in the db with the given name if none is
	 * found with that name null is returned
	 */
	@Override
	public TourTO getTourByName(String name) {
		Query q = currentSession().createQuery(SELECT_TOUR_BY_NAME);
		q.setParameter("name", name);
		TourTO tour = (q.list() != null) ? (TourTO) q.list().get(0) : null;

		if (tour != null) {// initialize the lazy loaded objects
			Hibernate.initialize(tour.getGuides());
		}
		System.out.println("GUIDES!!");
		for(Guide g : tour.getGuides()){
			System.out.println(g.getName());
		}
		
		return tour;
	}// end of getTourByName

	/**
	 * returns the tour that has the give tour id
	 */
	public TourTO getTourById(Integer id) {
		Query q = currentSession().createQuery(SELECT_TOUR_BY_ID);
		q.setParameter("id", id);
		TourTO tour = (q.list() != null) ? (TourTO) q.list().get(0) : null;
		if (tour != null) {// initialize the lazy loaded objects
			Hibernate.initialize(tour.getGuides());
		}
		return tour;
	}

}// end of class
