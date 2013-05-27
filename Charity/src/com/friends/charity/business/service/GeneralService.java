package com.friends.charity.business.service;

import java.util.List;
import java.util.Map;

import com.friends.charity.dao.GeneralDao;

public class GeneralService {
	private GeneralDao dao;

	public GeneralDao getDao() {
		if (dao == null) {
			dao = new GeneralDao();
		}
		return dao;
	}

	public void setDao(GeneralDao dao) {
		this.dao = dao;
	}

	public <T> T save(T t) throws Exception {
		return getDao().save(t);
	}

	public <T> T update(T t) {
		return getDao().update(t);
	}

	public <T> T delete(T t) throws Exception {
		return getDao().delete(t);
	}

	public <T> T select(String queryName, long id) {
		return getDao().select(queryName, id);
	}

	public <T> T select(String queryName, Map<String, Object> params) throws Exception {
		return getDao().select(queryName, params);
	}

	public <T> List<T> selectList(String queryName, Map<String, Object> params) {
		return getDao().selectList(queryName, params);
	}

	public <T> List<T> selectList(String queryName, Map<String, Object> params,
			Integer first, Integer max) throws Exception {
		return getDao().selectList(queryName, params, first, max);
	}
	public <T> T saveOrUpdate(T t)throws Exception{
		return getDao().saveOrUpdate(t);
	}
}
