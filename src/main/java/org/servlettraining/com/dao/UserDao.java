package org.servlettraining.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository; // ⭐ SPRING CORE

import org.servlettraining.com.entity.Users;

@Repository //SPRING CORE
public class UserDao {

	@PersistenceContext // using of DI
	private EntityManager em;

	@Transactional //
	public void registerUser(Users user) {

		em.persist(user);

	}

	public Users checkLogin(String username, String password) {

		TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u WHERE u.username=:un AND u.password=:pw",
				Users.class);

		query.setParameter("un", username);
		query.setParameter("pw", password);

		try {

			return query.getSingleResult();

		} catch (Exception e) {

			return null;

		}

	}

}