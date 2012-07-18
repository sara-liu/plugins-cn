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

import com.liferay.interview.NoSuchQuestionException;
import com.liferay.interview.model.Question;
import com.liferay.interview.model.impl.QuestionImpl;
import com.liferay.interview.model.impl.QuestionModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see QuestionPersistence
 * @see QuestionUtil
 * @generated
 */
public class QuestionPersistenceImpl extends BasePersistenceImpl<Question>
	implements QuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONSETID =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionSetId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONSETID =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionSetId",
			new String[] { Long.class.getName() },
			QuestionModelImpl.QUESTIONSETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONSETID = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionSetId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	public void cacheResult(Question question) {
		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		question.resetOriginalValues();
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	public void cacheResult(List<Question> questions) {
		for (Question question : questions) {
			if (EntityCacheUtil.getResult(
						QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, question.getPrimaryKey()) == null) {
				cacheResult(question);
			}
			else {
				question.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Question question) {
		EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Question> questions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Question question : questions) {
			EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, question.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	public Question create(long questionId) {
		Question question = new QuestionImpl();

		question.setNew(true);
		question.setPrimaryKey(questionId);

		return question;
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question remove(long questionId)
		throws NoSuchQuestionException, SystemException {
		return remove(Long.valueOf(questionId));
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question that was removed
	 * @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question remove(Serializable primaryKey)
		throws NoSuchQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Question question = (Question)session.get(QuestionImpl.class,
					primaryKey);

			if (question == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchQuestionException nsee) {
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
	protected Question removeImpl(Question question) throws SystemException {
		question = toUnwrappedModel(question);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, question);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(question);

		return question;
	}

	@Override
	public Question updateImpl(com.liferay.interview.model.Question question,
		boolean merge) throws SystemException {
		question = toUnwrappedModel(question);

		boolean isNew = question.isNew();

		QuestionModelImpl questionModelImpl = (QuestionModelImpl)question;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, question, merge);

			question.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else {
			if ((questionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONSETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(questionModelImpl.getOriginalQuestionSetId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONSETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONSETID,
					args);

				args = new Object[] {
						Long.valueOf(questionModelImpl.getQuestionSetId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONSETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONSETID,
					args);
			}
		}

		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		return question;
	}

	protected Question toUnwrappedModel(Question question) {
		if (question instanceof QuestionImpl) {
			return question;
		}

		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setNew(question.isNew());
		questionImpl.setPrimaryKey(question.getPrimaryKey());

		questionImpl.setQuestionId(question.getQuestionId());
		questionImpl.setUserId(question.getUserId());
		questionImpl.setCreateDate(question.getCreateDate());
		questionImpl.setModifiedDate(question.getModifiedDate());
		questionImpl.setQuestionSetId(question.getQuestionSetId());
		questionImpl.setTitle(question.getTitle());
		questionImpl.setDescription(question.getDescription());
		questionImpl.setType(question.getType());
		questionImpl.setOrder(question.getOrder());

		return questionImpl;
	}

	/**
	 * Returns the question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question
	 * @throws com.liferay.portal.NoSuchModelException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question with the primary key or throws a {@link com.liferay.interview.NoSuchQuestionException} if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question findByPrimaryKey(long questionId)
		throws NoSuchQuestionException, SystemException {
		Question question = fetchByPrimaryKey(questionId);

		if (question == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + questionId);
			}

			throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				questionId);
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question fetchByPrimaryKey(long questionId)
		throws SystemException {
		Question question = (Question)EntityCacheUtil.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, questionId);

		if (question == _nullQuestion) {
			return null;
		}

		if (question == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				question = (Question)session.get(QuestionImpl.class,
						Long.valueOf(questionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (question != null) {
					cacheResult(question);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, questionId, _nullQuestion);
				}

				closeSession(session);
			}
		}

		return question;
	}

	/**
	 * Returns all the questions where questionSetId = &#63;.
	 *
	 * @param questionSetId the question set ID
	 * @return the matching questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findByQuestionSetId(long questionSetId)
		throws SystemException {
		return findByQuestionSetId(questionSetId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions where questionSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionSetId the question set ID
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findByQuestionSetId(long questionSetId, int start,
		int end) throws SystemException {
		return findByQuestionSetId(questionSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions where questionSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionSetId the question set ID
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findByQuestionSetId(long questionSetId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONSETID;
			finderArgs = new Object[] { questionSetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONSETID;
			finderArgs = new Object[] {
					questionSetId,
					
					start, end, orderByComparator
				};
		}

		List<Question> list = (List<Question>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Question question : list) {
				if ((questionSetId != question.getQuestionSetId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONSETID_QUESTIONSETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionSetId);

				list = (List<Question>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first question in the ordered set where questionSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionSetId the question set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws com.liferay.interview.NoSuchQuestionException if a matching question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question findByQuestionSetId_First(long questionSetId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		List<Question> list = findByQuestionSetId(questionSetId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionSetId=");
			msg.append(questionSetId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last question in the ordered set where questionSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionSetId the question set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws com.liferay.interview.NoSuchQuestionException if a matching question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question findByQuestionSetId_Last(long questionSetId,
		OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		int count = countByQuestionSetId(questionSetId);

		List<Question> list = findByQuestionSetId(questionSetId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionSetId=");
			msg.append(questionSetId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where questionSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the primary key of the current question
	 * @param questionSetId the question set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question[] findByQuestionSetId_PrevAndNext(long questionId,
		long questionSetId, OrderByComparator orderByComparator)
		throws NoSuchQuestionException, SystemException {
		Question question = findByPrimaryKey(questionId);

		Session session = null;

		try {
			session = openSession();

			Question[] array = new QuestionImpl[3];

			array[0] = getByQuestionSetId_PrevAndNext(session, question,
					questionSetId, orderByComparator, true);

			array[1] = question;

			array[2] = getByQuestionSetId_PrevAndNext(session, question,
					questionSetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Question getByQuestionSetId_PrevAndNext(Session session,
		Question question, long questionSetId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTION_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONSETID_QUESTIONSETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionSetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(question);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Question> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end,
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

		List<Question> list = (List<Question>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the questions where questionSetId = &#63; from the database.
	 *
	 * @param questionSetId the question set ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionSetId(long questionSetId)
		throws SystemException {
		for (Question question : findByQuestionSetId(questionSetId)) {
			remove(question);
		}
	}

	/**
	 * Removes all the questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions where questionSetId = &#63;.
	 *
	 * @param questionSetId the question set ID
	 * @return the number of matching questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionSetId(long questionSetId)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionSetId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONSETID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONSETID_QUESTIONSETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionSetId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONSETID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTION);

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
	 * Initializes the question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.interview.model.Question")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Question>> listenersList = new ArrayList<ModelListener<Question>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Question>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuestionImpl.class.getName());
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
	private static final String _SQL_SELECT_QUESTION = "SELECT question FROM Question question";
	private static final String _SQL_SELECT_QUESTION_WHERE = "SELECT question FROM Question question WHERE ";
	private static final String _SQL_COUNT_QUESTION = "SELECT COUNT(question) FROM Question question";
	private static final String _SQL_COUNT_QUESTION_WHERE = "SELECT COUNT(question) FROM Question question WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONSETID_QUESTIONSETID_2 = "question.questionSetId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Question exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Question exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionPersistenceImpl.class);
	private static Question _nullQuestion = new QuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Question> toCacheModel() {
				return _nullQuestionCacheModel;
			}
		};

	private static CacheModel<Question> _nullQuestionCacheModel = new CacheModel<Question>() {
			public Question toEntityModel() {
				return _nullQuestion;
			}
		};
}