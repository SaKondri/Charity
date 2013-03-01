package com.friends.charity.dao;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GeneralDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Session session;

	public GeneralDao() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("charity");
		entityManager = entityManagerFactory.createEntityManager();
		session = entityManager.unwrap(Session.class);
	}

	public <T> T save(T t) throws Exception {
		try {
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			session.flush();
			session.clear();
		} catch (Exception e) {
			throw new Exception();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> T delete(T t) throws Exception {
		try {
			Transaction transaction = session.beginTransaction();
			t = load(t);
			session.delete(t);
			transaction.commit();
			session.flush();

		} catch (Exception e) {
			throw new Exception();
		} finally {
			session.clear();
		}
		return t;
	}

	public <T> T load(T t) {
		session.buildLockRequest(LockOptions.NONE).lock(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> T select(String queryName, long id) {
		Transaction transaction = null;
		T t = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(queryName);
			query.setParameter("id", id);
			t = (T) query.uniqueResult();
			transaction.commit();
			session.flush();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.clear();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> T select(String queryName, Map<String, Object> params) {
		Transaction transaction = null;
		T t = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(queryName);
			for (Entry<String, Object> entry : params.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			t = (T) query.uniqueResult();
			transaction.commit();
			session.flush();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.clear();
		}
		return t;
	}

}
