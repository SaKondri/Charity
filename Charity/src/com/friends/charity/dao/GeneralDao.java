package com.friends.charity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.friends.charity.model.Login;

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
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			session.flush();
			session.clear();
		} catch (Exception e) {
			transaction.rollback();
			throw new Exception();
		}
		return t;
	}

	public <T> T update(T t) {
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.clear();
		}
		return t;
	}

	public <T> T delete(T t) throws Exception {
		try {
			t = load(t);
			session.delete(t);
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
		T t = null;
		try {
			Query query = session.getNamedQuery(queryName);
			query.setParameter("id", id);
			t = (T) query.uniqueResult();
			session.flush();
		} catch (Exception e) {
		} finally {
			session.clear();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> T select(String queryName, Map<String, Object> params) {
		T t = null;
		try {
			Query query = session.getNamedQuery(queryName);
			for (Entry<String, Object> entry : params.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			t = (T) query.uniqueResult();
			session.flush();
		} catch (Exception e) {
		} finally {
			session.clear();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> selectList(String queryName, Map<String, Object> params) {
		// List<T> result = new ArrayList<>();
		// Query query = session.getNamedQuery(queryName);
		// if (params != null) {
		// for (Entry<String, Object> ent : params.entrySet()) {
		// query.setParameter(ent.getKey(), ent.getValue());
		// }
		// }
		// result = query.list();
		// session.flush();
		// session.clear();
		// return result;
		return null;

	}

	@SuppressWarnings("unchecked")
	public <T> List<T> selectList(String queryName, Map<String, Object> params,
			Integer first, Integer max) throws Exception {
		List<T> result = new ArrayList<>();
		try {
			Query query = session.getNamedQuery(queryName);
			if (params != null) {
				for (Entry<String, Object> e : params.entrySet()) {
					query.setParameter(e.getKey(), e.getValue());
				}
			}
			if (first != null) {
				query.setFirstResult(first);
			}
			if (max != null) {
				query.setMaxResults(max);
			}
			result = query.list();
			session.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			session.clear();
		}
		return result;
	}

	// public Login getUsernamePassword(String username, String password) {
	// Login login = null;
	//
	// Query query = session.getNamedQuery("selectUsernamePassword");
	// query.setParameter("username", username);
	// query.setParameter("password", password);
	// login = (Login) query.uniqueResult();
	// return login;
	// }

	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(String namedQuery, Map<String, Object> params) {
		List<T> result = new ArrayList<>();
		Query query = session.getNamedQuery(namedQuery);
		for (Entry<String, Object> t : params.entrySet()) {
			query.setParameter(t.getKey(), t.getValue());
		}
//		query.setParameter("username", "Ali");
//		query.setParameter("password", "Alavi");
		result = query.list();
		return result;
	}
}
