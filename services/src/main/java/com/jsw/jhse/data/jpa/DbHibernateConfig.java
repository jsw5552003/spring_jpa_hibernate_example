package com.jsw.jhse.data.jpa;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA and Hibernate configuration class. This class uses a property file 
 * <code>db_hibernate.properties</code> to configure the data source and
 * other beans needed for JPA and Hibernate.
 *  
 * @author jsicree
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.jsw.jhse.data.services.impl"})
@EnableJpaRepositories(basePackages = {"com.jsw.jhse.data.jpa.repository"})
@PropertySource({"classpath:db_hibernate.properties"})
public class DbHibernateConfig {

	private static final String PROPERTY_NAME_DATABASE_DRIVER_TYPE = "db.driverType";
	private static final String PROPERTY_NAME_DATABASE_SERVER = "db.server";
	private static final String PROPERTY_NAME_DATABASE_PORT = "db.port";
	private static final String PROPERTY_NAME_DATABASE_NAME = "db.name";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";	

    protected final static Logger  log = LoggerFactory.getLogger(DbHibernateConfig.class);
	
	@Resource
	private Environment environment;
	

//	@Bean
//	public DataSource dataSource() {
//
//		DataSource ds = null;
//
//		try {
//		    Context initContext = new InitialContext();
//	        NamingEnumeration<NameClassPair> initEnum = initContext.list("java:comp/env");
//	        if (initEnum != null) {
//	            while (initEnum.hasMore()) {
//	                log.info("java:comp/env: " + initEnum.next().getName());
//	            }
//	        }
//		    
//		    Context envContext = (Context)initContext.lookup("java:/comp/env");
//            NamingEnumeration<NameClassPair> envEnum = envContext.list("jdbc");
//            if (envEnum != null) {
//                while (envEnum.hasMore()) {
//                    log.info("jdbc: " + envEnum.next().getName());
//                }
//            }
//
//		    ds = (DataSource)envContext.lookup("jdbc/WebToolsDs");
//		}
//        catch (NamingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//		return ds;
//	}

    @Bean
    public DataSource dataSource() {

        OracleDataSource ds = null;

        try {
            ds = new OracleDataSource();

            ds.setDriverType(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER_TYPE));
            ds.setServerName(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_SERVER));
            ds.setPortNumber(Integer.parseInt(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_PORT)));
            ds.setDatabaseName(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_NAME));
            ds.setUser(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
            ds.setPassword(environment
                    .getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        } catch (SQLException se) {

        }
        return ds;
    }
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan(environment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
				
		Properties jpaProperties = new Properties();
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));		
		lef.setJpaProperties(jpaProperties);		
		
		return lef;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
