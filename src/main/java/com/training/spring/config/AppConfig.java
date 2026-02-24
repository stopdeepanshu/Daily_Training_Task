package com.training.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.spring.Car;
import com.training.spring.Person;

@Configuration
@ComponentScan("com.training.spring")
@EnableTransactionManagement
public class AppConfig {
	@Bean
	Person person() {
		Person person = new Person(23);
		person.setFirstName("John");
		person.setLastName("Doe");
		return person;
	}

	@Bean
	@Scope("prototype")
	Car car() {
		Car car = new Car();
		car.setMake("Hyundai");
		car.setModel("Sonata");
		car.setYear(2020);
		return car;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/springdb");
		ds.setUsername("postgres");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager txManager = new JpaTransactionManager();

		txManager.setEntityManagerFactory(emf);

		return txManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.training.spring.entity");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(vendorAdapter);
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		factory.setJpaProperties(props);
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

}