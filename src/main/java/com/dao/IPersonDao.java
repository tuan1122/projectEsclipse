package com.dao;

import java.util.List;
import com.entity.person;

public interface IPersonDao {
	List<person> getAllPerson();
    person getPersonById(String personId);
    void createPerson(person person);
    void updatePerson(person person);
    void deletePerson(String personId);
    void deletePerson(String personId);
   // boolean articleExists(String title, String category);
}
