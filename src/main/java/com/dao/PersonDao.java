package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.entity.person;

@Transactional
@Repository
public class PersonDao implements IPersonDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	public List<person> getAllPerson() {
		String hql = "FROM person ORDER BY article_id DESC";
		return (List<person>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public person getPersonById(String personId) {
		try {
			return (person) entityManager.createQuery("FROM person where article_id = :article_id")
					.setParameter("article_id", personId).getSingleResult();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		// return (person)entityManager.find(person.class, personId);
	}

	@Override
	public void createPerson(person person) {
		// TODO Auto-generated method stub
		// entityManager.createQuery("INSERT INTO person(article_id,name,address) VALUES
		// (:article_id,:name,:address)")
		// .setParameter("article_id", person.getArticleId())
		// .setParameter("name", person.getName())
		// .setParameter("address", person.getAddress());
		// entityManager.persist( person );
		entityManager.persist( person );
//		try {
//			entityManager.getTransaction().begin();
//			
////			entityManager.createNativeQuery("INSERT INTO person(article_id, name, address) VALUES (:article_id,:name,:address)")
////			.setParameter("article_id", person.getArticleId())
////			.setParameter("name", person.getName())
////			.setParameter("address", person.getAddress()).executeUpdate();
//			
//			entityManager.flush();
//			entityManager.getTransaction().commit();
//		}catch(HibernateError e) {
//			 System.out.println(e.getMessage()+"ccccccccccccccccccccc");
//			 entityManager.getTransaction().rollback();
//		}finally {
//			entityManager.close();
//		}
	}

	@Override
	public void updatePerson(person person) {
		// TODO Auto-generated method stub
		entityManager.merge(person);

	}

	@Override
	public void deletePerson(String personId) {
		entityManager.remove(getPersonById(personId));
//		try {
//			entityManager.getTransaction().begin();
//			entityManager.remove(getPersonById(personId));
//			entityManager.getTransaction().commit();
//		} catch (HibernateError e) {
//			entityManager.getTransaction().rollback();
//		} finally {
//			entityManager.close();
//		}
	}

}
