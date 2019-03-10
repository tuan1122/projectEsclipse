package com.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.entity.person;

public interface IPersonService {
	List<person> getAllArticles();
    person getPersonById(String personId);
    void createPerson(person person);
    void updatePerson(person person);
    @Secured ({"ROLE_ADMIN"})
    void deletePerson(String articleId);
}
