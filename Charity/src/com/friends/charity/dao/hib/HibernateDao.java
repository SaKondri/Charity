//package com.friends.charity.dao.hib;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//
//public class HibernateDao {
//
//	private Configuration configuration;
//	private SessionFactory factory;
//	private Session session;
//	private Transaction transaction;
//
//	public <T> HibernateDao(T t) {
//		configuration = new Configuration();
//		configuration.addAnnotatedClass(t.getClass());
//		configuration.configure("hibernate.cfg.xml");
//
//		// new SchemaExport(configuration).create(true, true);
//
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
//				.applySettings(configuration.getProperties())
//				.buildServiceRegistry();
//		factory = configuration.buildSessionFactory(serviceRegistry);
//
//		session = factory.getCurrentSession();
//	}
//
//	public <T> void saved(T t) throws Exception {
//		try {
//			transaction = session.beginTransaction();
//			session.save(t);
//			transaction.commit();
//		} catch (Exception exception) {
//			transaction.rollback();
//		}
//
//	}
//}
