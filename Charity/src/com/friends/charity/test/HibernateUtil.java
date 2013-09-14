//package com.friends.charity.test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
//import com.friends.charity.business.service.GeneralService;
//import com.friends.charity.business.service.model.LoginService;
//import com.friends.charity.dao.GeneralDao;
//import com.friends.charity.model.Login;
//import com.friends.charity.model.User;
//import com.friends.charity.model.UsernamePassword;
//import com.friends.charity.view.template.general.menu.right.about.TariekhcheShow;
//
//public class HibernateUtil {
//	private static SessionFactory sessionFactory;
//	private static ServiceRegistry serviceRegistry;
//
//	static {
//		try {
//			// Configuration configuration = new Configuration();
//			Configuration configuration = new Configuration().configure();
//
//			serviceRegistry = new ServiceRegistryBuilder().applySettings(
//					configuration.getProperties()).buildServiceRegistry();
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		} catch (HibernateException he) {
//			System.err.println("Error creating Session: " + he);
//			throw new ExceptionInInitializerError(he);
//		}
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//}
