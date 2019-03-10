package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.Users;

@Repository
@Transactional
public class UserDao implements IUserDao{
	@PersistenceContext	
	private EntityManager entityManager;
	
	public Users getActiveUser(String userName) {
		Users activeUserInfo = new Users();
		//short enabled = 1;
		activeUserInfo =(Users)entityManager
				.createQuery("SELECT u FROM Users u WHERE userName=?")
				.setParameter(1, userName).getSingleResult();
		
		return activeUserInfo;
	}
}
