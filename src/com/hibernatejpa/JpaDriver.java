package com.hibernatejpa;

import com.hibernatejpa.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaDriver {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaFile");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

//		Product prod1=new Product();
//		prod1.setProdName("PS-5");
//		prod1.setPrice(1999);
//		prod1.setProdDesc("Best Gaming device");
//		
//		em.persist(prod1);  //saving the entity, 
//		tx.commit();
//		System.out.println("Data saved successfully.");
		System.out.println("All tables created.");
		tx.commit();
		em.close();
		emf.close();
	}
}
