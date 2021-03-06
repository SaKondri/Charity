package com.friends.charity.business.service;

import java.util.List;
import java.util.Map;

import com.friends.charity.dao.GeneralDao;
import com.friends.charity.model.admin.about.Qustion;

public class GeneralService {
	public <T> T save(T t) throws Exception {
		return GeneralDao.getGeneralDao().save(t);
	}

	public void clear() {
		GeneralDao.getGeneralDao().clear();
	}

	public <T> T update(T t) {
		return GeneralDao.getGeneralDao().update(t);
	}

	public <T> T lazyUpdate(T t) {
		return GeneralDao.getGeneralDao().lazyUpdate(t);
	}

	public <T> T delete(T t) throws Exception {
		return GeneralDao.getGeneralDao().delete(t);
	}

	public <T> T select(String queryName, long id) {
		return GeneralDao.getGeneralDao().select(queryName, id);
	}

	public <T> T LazySelect(String queryName, Map<String, Object> params) throws Exception {
		return GeneralDao.getGeneralDao().LazySelect(queryName, params);
	}

	public <T> T select(String queryName, Map<String, Object> params)
			throws Exception {
		return GeneralDao.getGeneralDao().select(queryName, params);
	}

	public <T> List<T> selectList(String queryName, Map<String, Object> params) {
		return GeneralDao.getGeneralDao().selectList(queryName, params);
	}

	public <T> List<T> selectLazyList(String queryName,
			Map<String, Object> params) {
		return GeneralDao.getGeneralDao().selectLazyList(queryName, params);

	}

	public <T> List<T> selectList(String queryName, Map<String, Object> params,
			Integer first, Integer max) throws Exception {
		return GeneralDao.getGeneralDao().selectList(queryName, params, first,
				max);
	}

	public <T> T saveOrUpdate(T t) throws Exception {
		return GeneralDao.getGeneralDao().saveOrUpdate(t);
	}

	public List<Qustion> selectListValue(Integer first, Integer max) {
		return GeneralDao.getGeneralDao().selectListValue(first, max);
	}

	public <T> Long tableSize(String namedQuery) {
		return GeneralDao.getGeneralDao().tableSize(namedQuery);
	}
}
