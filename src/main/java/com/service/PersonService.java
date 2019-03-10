package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.IPersonDao;
import com.entity.person;

@Service
public class PersonService implements IPersonService{
	@Autowired
	private IPersonDao personDAO;
	
	@Override
	public List<person> getAllArticles() {
		// TODO Auto-generated method stub
		return personDAO.getAllPerson();
	}

	@Override
	public person getPersonById(String personId) {
		// TODO Auto-generated method stub
		return personDAO.getPersonById(personId);
	}

	@Override
	public void createPerson(person person) {
		// TODO Auto-generated method stub
		 personDAO.createPerson(person);
	}

	@Override
	public void updatePerson(person person) {
		// TODO Auto-generated method stub
		personDAO.updatePerson(person);
	}

	@Override
	public void deletePerson(String personId) {
		// TODO Auto-generated method stub
				personDAO.deletePerson(personId);
	}

}
