package com.evertour.model.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertour.model.DAO.UserDAO;
import com.evertour.model.DMO.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User getUserById(Long id) {
		Criteria criteria = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("id", new Long(id)));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User getUserByUserName(String name) {
		Criteria criteria = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", name));
		return (User) criteria.uniqueResult();
	}

	@Override
	public long saveUser(User user) {
		return (Long)getCurrentSession().save(user);
	}


	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override 
	public List<User> getAllUsers() {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		return  criteria.list();
	}
	
	
	

}//end of class
