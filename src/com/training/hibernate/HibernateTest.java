package com.training.hibernate;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import com.training.hibernate.entity.Order;
import com.training.hibernate.entity.Product;
import com.training.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) { 

		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();// transaction should be on session only
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();

		product1.setProdName("Mac Book");
		product1.setProdDesc("Electronics Device");
		product1.setPrice(5000);
		
		session.persist(product1);// saving only
		
		
		product2.setProdName("Maruti Car");
		product2.setProdDesc("Automobile");
		product2.setPrice(8953);
		
		
		session.persist(product2);// saving only
		
		product3.setProdName("Milton Bottle");
		product3.setProdDesc("Household");
		product3.setPrice(100);
		
		session.persist(product3);// saving only
		
		
		Order order1 = new Order();
		order1.setOrderDate(LocalDate.now());
		order1.setOrderType("brand new");
		order1.setProduct(product1);
		
		
		Order order2 = new Order();
		order2.setOrderDate(LocalDate.now());
		order2.setOrderType("brand new");
		order2.setProduct(product2);
		
		
		Order order3 = new Order();
		order3.setOrderDate(LocalDate.now());
		order3.setOrderType("brand new");
		order3.setProduct(product3);

		session.persist(order3);
		
		//find the product
		
//		Product prod=session.find(Product.class, 1);
//		System.out.println(prod.getProdName());
		
		//find all the product
		transaction.commit();// autcommit by default off, thats why we need to do this.
		
		System.out.println("===================================================================");

		SelectionQuery<Product> selectionquery = (SelectionQuery<Product>)session.createSelectionQuery("from Product", Product.class);
		List<Product> resultSet=selectionquery.getResultList();
		for (Product p : resultSet) {
		    System.out.println(p.getProdId() + " - " + p.getProdName());
		}
		
		System.out.println("===================================================================");
		session.close();
		System.out.println("Data Saved Successfully.");
	}
}
