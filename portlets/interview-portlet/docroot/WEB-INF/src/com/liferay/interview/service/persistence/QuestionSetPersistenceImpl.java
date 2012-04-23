/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.interview.service.persistence;

import com.liferay.interview.NoSuchQuestionSetException;
import com.liferay.interview.model.QuestionSet;
import com.liferay.interview.model.impl.QuestionSetImpl;
import com.liferay.interview.model.impl.QuestionSetModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the question set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see QuestionSetPersistence
 * @see QuestionSetUtil
 * @generated
 */
public class QuestionSetPersistenceImpl extends BasePersistenceImpl<QuestionSet>
	implements QuestionSetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionSetUtil} to access the question set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionSetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetModelImpl.FINDER_CACHE_ENABLED, QuestionSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetModelImpl.FINDER_CACHE_ENABLED, QuestionSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the question set in the entity cache if it is enabled.
	 *
	 * @param questionSet the question set
	 */
	public void cacheResult(QuestionSet questionSet) {
		EntityCacheUtil.putResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetImpl.class, questionSet.getPrimaryKey(), questionSet);

		questionSet.resetOriginalValues();
	}

	/**
	 * Caches the question sets in the entity cache if it is enabled.
	 *
	 * @param questionSets the question sets
	 */
	public void cacheResult(List<QuestionSet> questionSets) {
		for (QuestionSet questionSet : questionSets) {
			if (EntityCacheUtil.getResult(
						QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
						QuestionSetImpl.class, questionSet.getPrimaryKey()) == null) {
				cacheResult(questionSet);
			}
			else {
				questionSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question sets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionSetImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionSetImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question set.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionSet questionSet) {
		EntityCacheUtil.removeResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetImpl.class, questionSet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QuestionSet> questionSets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionSet questionSet : questionSets) {
			EntityCacheUtil.removeResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
				QuestionSetImpl.class, questionSet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question set with the primary key. Does not add the question set to the database.
	 *
	 * @param questionSetId the primary key for the new question set
	 * @return the new question set
	 */
	public QuestionSet create(long questionSetId) {
		QuestionSet questionSet = new QuestionSetImpl();

		questionSet.setNew(true);
		questionSet.setPrimaryKey(questionSetId);

		return questionSet;
	}

	/**
	 * Removes the question set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionSetId the primary key of the question set
	 * @return the question set that was removed
	 * @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionSet remove(long questionSetId)
		throws NoSuchQuestionSetException, SystemException {
		return remove(Long.valueOf(questionSetId));
	}

	/**
	 * Removes the question set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question set
	 * @return the question set that was removed
	 * @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionSet remove(Serializable primaryKey)
		throws NoSuchQuestionSetException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QuestionSet questionSet = (QuestionSet)session.get(QuestionSetImpl.class,
					primaryKey);

			if (questionSet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionSet);
		}
		catch (NoSuchQuestionSetException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected QuestionSet removeImpl(QuestionSet questionSet)
		throws SystemException {
		questionSet = toUnwrappedModel(questionSet);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, questionSet);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(questionSet);

		return questionSet;
	}

	@Override
	public QuestionSet updateImpl(
		com.liferay.interview.model.QuestionSet questionSet, boolean merge)
		throws SystemException {
		questionSet = toUnwrappedModel(questionSet);

		boolean isNew = questionSet.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, questionSet, merge);

			questionSet.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
			QuestionSetImpl.class, questionSet.getPrimaryKey(), questionSet);

		return questionSet;
	}

	protected QuestionSet toUnwrappedModel(QuestionSet questionSet) {
		if (questionSet instanceof QuestionSetImpl) {
			return questionSet;
		}

		QuestionSetImpl questionSetImpl = new QuestionSetImpl();

		questionSetImpl.setNew(questionSet.isNew());
		questionSetImpl.setPrimaryKey(questionSet.getPrimaryKey());

		questionSetImpl.setQuestionSetId(questionSet.getQuestionSetId());
		questionSetImpl.setUserId(questionSet.getUserId());
		questionSetImpl.setCreateDate(questionSet.getCreateDate());
		questionSetImpl.setModifiedDate(questionSet.getModifiedDate());
		questionSetImpl.setTitle(questionSet.getTitle());

		return questionSetImpl;
	}

	/**
	 * Returns the question set with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question set
	 * @return the question set
	 * @throws com.liferay.portal.NoSuchModelException if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question set with the primary key or throws a {@link com.liferay.interview.NoSuchQuestionSetException} if it could not be found.
	 *
	 * @param questionSetId the primary key of the question set
	 * @return the question set
	 * @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionSet findByPrimaryKey(long questionSetId)
		throws NoSuchQuestionSetException, SystemException {
		QuestionSet questionSet = fetchByPrimaryKey(questionSetId);

		if (questionSet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + questionSetId);
			}

			throw new NoSuchQuestionSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				questionSetId);
		}

		return questionSet;
	}

	/**
	 * Returns the question set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question set
	 * @return the question set, or <code>null</code> if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionSet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionSetId the primary key of the question set
	 * @return the question set, or <code>null</code> if a question set with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionSet fetchByPrimaryKey(long questionSetId)
		throws SystemException {
		QuestionSet questionSet = (QuestionSet)EntityCacheUtil.getResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
				QuestionSetImpl.class, questionSetId);

		if (questionSet == _nullQuestionSet) {
			return null;
		}

		if (questionSet == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				questionSet = (QuestionSet)session.get(QuestionSetImpl.class,
						Long.valueOf(questionSetId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (questionSet != null) {
					cacheResult(questionSet);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionSetModelImpl.ENTITY_CACHE_ENABLED,
						QuestionSetImpl.class, questionSetId, _nullQuestionSet);
				}

				closeSession(session);
			}
		}

		return questionSet;
	}

	/**
	 * Returns all the question sets.
	 *
	 * @return the question sets
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionSet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of question sets
	 * @param end the upper bound of the range of question sets (not inclusive)
	 * @return the range of question sets
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionSet> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the question sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of question sets
	 * @param end the upper bound of the range of question sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of question sets
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionSet> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<QuestionSet> list = (List<QuestionSet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTIONSET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONSET;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<QuestionSet>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<QuestionSet>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the question sets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (QuestionSet questionSet : findAll()) {
			remove(questionSet);
		}
	}

	/**
	 * Returns the number of question sets.
	 *
	 * @return the number of question sets
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONSET);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the question set persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.interview.model.QuestionSet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QuestionSet>> listenersList = new ArrayList<ModelListener<QuestionSet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QuestionSet>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(QuestionSetImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = InterviewPersistence.class)
	protected InterviewPersistence interviewPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionSetPersistence.class)
	protected QuestionSetPersistence questionSetPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_QUESTIONSET = "SELECT questionSet FROM QuestionSet questionSet";
	private static final String _SQL_COUNT_QUESTIONSET = "SELECT COUNT(questionSet) FROM QuestionSet questionSet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionSet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionSet exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionSetPersistenceImpl.class);
	private static QuestionSet _nullQuestionSet = new QuestionSetImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QuestionSet> toCacheModel() {
				return _nullQuestionSetCacheModel;
			}
		};

	private static CacheModel<QuestionSet> _nullQuestionSetCacheModel = new CacheModel<QuestionSet>() {
			public QuestionSet toEntityModel() {
				return _nullQuestionSet;
			}
		};
}