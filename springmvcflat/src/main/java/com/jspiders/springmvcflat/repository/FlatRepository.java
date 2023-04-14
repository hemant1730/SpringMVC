package com.jspiders.springmvcflat.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvcflat.pojo.FlatPojo;

@Repository
public class FlatRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("flat");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public FlatPojo addFlat(String name, String email, long contact, String city, double rent) {
		openConnection();
		transaction.begin();
		FlatPojo flat = new FlatPojo();
		flat.setName(name);
		flat.setEmail(email);
		flat.setContact(contact);
		flat.setCity(city);
		flat.setRent(rent);
		manager.persist(flat);
		transaction.commit();
		closeConnection();
		return flat;
	}

	public FlatPojo searchFlat(int id) {
		openConnection();
		transaction.begin();
		FlatPojo flat = manager.find(FlatPojo.class, id);
		transaction.commit();
		closeConnection();
		return flat;
	}

	public List<FlatPojo> searchAllFlats() {
		openConnection();
		transaction.begin();
		jpql = "from FlatPojo";
		query = manager.createQuery(jpql);
		List<FlatPojo> flats = query.getResultList();
		transaction.commit();
		closeConnection();
		return flats;
	}

	public void removeFlat(int id) {
		openConnection();
		transaction.begin();
		FlatPojo flat = manager.find(FlatPojo.class, id);
		manager.remove(flat);
		transaction.commit();
		closeConnection();
	}

	public FlatPojo updateFlat(int id, String name, String email, long contact, String city, double rent) {
		openConnection();
		transaction.begin();
		FlatPojo flat = manager.find(FlatPojo.class, id);
		flat.setName(name);
		flat.setEmail(email);
		flat.setContact(contact);
		flat.setCity(city);
		flat.setRent(rent);
		manager.persist(flat);
		transaction.commit();
		closeConnection();
		return flat;
	}

	public void login(String username, String password) {

	}
}
