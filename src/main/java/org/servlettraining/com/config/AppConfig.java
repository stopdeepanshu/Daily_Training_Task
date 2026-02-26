package org.servlettraining.com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.servlettraining.com")
@EnableTransactionManagement
public class AppConfig {

   
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds =
                new DriverManagerDataSource();

        ds.setDriverClassName(
                "org.postgresql.Driver");

        ds.setUrl(
                "jdbc:postgresql://localhost:5432/postgres");

        ds.setUsername("postgres");

        ds.setPassword("root");

        return ds;
    }


    // EntityManagerFactory Bean
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setDataSource(dataSource());

        factory.setPackagesToScan(
                "org.servlettraining.com.entity");

        HibernateJpaVendorAdapter adapter =
                new HibernateJpaVendorAdapter();

        factory.setJpaVendorAdapter(adapter);


        Properties props = new Properties();

        props.put(
                "hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect");

        props.put(
                "hibernate.hbm2ddl.auto",
                "update");

        props.put(
                "hibernate.show_sql",
                "true");

        factory.setJpaProperties(props);

        return factory;
    }


    // Transaction Manager
    @Bean
    public JpaTransactionManager transactionManager() {

        return new JpaTransactionManager(
                entityManagerFactory().getObject());

    }

}