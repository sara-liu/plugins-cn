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

import com.liferay.interview.NoSuchInterviewException;
import com.liferay.interview.model.Interview;
import com.liferay.interview.model.impl.InterviewImpl;
import com.liferay.interview.model.impl.InterviewModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the interview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see InterviewPersistence
 * @see InterviewUtil
 * @generated
 */
public class InterviewPersistenceImpl extends BasePersistenceImpl<Interview>
	implements InterviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InterviewUtil} to access the interview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InterviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			InterviewModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, InterviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the interview in the entity cache if it is enabled.
	 *
	 * @param interview the interview
	 */
	public void cacheResult(Interview interview) {
		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		interview.resetOriginalValues();
	}

	/**
	 * Caches the interviews in the entity cache if it is enabled.
	 *
	 * @param interviews the interviews
	 */
	public void cacheResult(List<Interview> interviews) {
		for (Interview interview : interviews) {
			if (EntityCacheUtil.getResult(
						InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, interview.getPrimaryKey()) == null) {
				cacheResult(interview);
			}
			else {
				interview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interviews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InterviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InterviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Interview interview) {
		EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	public void clearCache(List<Interview> interviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Interview interview : interviews) {
			EntityCacheUtil.removeResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, interview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new interview with the primary key. Does not add the interview to the database.
	 *
	 * @param interviewId the primary key for the new interview
	 * @return the new interview
	 */
	public Interview create(long interviewId) {
		Interview interview = new InterviewImpl();

		interview.setNew(true);
		interview.setPrimaryKey(interviewId);

		String uuid = PortalUUIDUtil.generate();

		interview.setUuid(uuid);

		return interview;
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview that was removed
	 * @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview remove(long interviewId)
		throws NoSuchInterviewException, SystemException {
		return remove(Long.valueOf(interviewId));
	}

	/**
	 * Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview that was removed
	 * @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview remove(Serializable primaryKey)
		throws NoSuchInterviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Interview interview = (Interview)session.get(InterviewImpl.class,
					primaryKey);

			if (interview == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interview);
		}
		catch (NoSuchInterviewException nsee) {
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
	protected Interview removeImpl(Interview interview)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, interview);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(interview);

		return interview;
	}

	@Override
	public Interview updateImpl(
		com.liferay.interview.model.Interview interview, boolean merge)
		throws SystemException {
		interview = toUnwrappedModel(interview);

		boolean isNew = interview.isNew();

		InterviewModelImpl interviewModelImpl = (InterviewModelImpl)interview;

		if (Validator.isNull(interview.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			interview.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, interview, merge);

			interview.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InterviewModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else {
			if ((interviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interviewModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { interviewModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
			InterviewImpl.class, interview.getPrimaryKey(), interview);

		return interview;
	}

	protected Interview toUnwrappedModel(Interview interview) {
		if (interview instanceof InterviewImpl) {
			return interview;
		}

		InterviewImpl interviewImpl = new InterviewImpl();

		interviewImpl.setNew(interview.isNew());
		interviewImpl.setPrimaryKey(interview.getPrimaryKey());

		interviewImpl.setUuid(interview.getUuid());
		interviewImpl.setInterviewId(interview.getInterviewId());
		interviewImpl.setUserId(interview.getUserId());
		interviewImpl.setCreateDate(interview.getCreateDate());
		interviewImpl.setModifiedDate(interview.getModifiedDate());
		interviewImpl.setName(interview.getName());
		interviewImpl.setEmailAddress(interview.getEmailAddress());
		interviewImpl.setStartDate(interview.getStartDate());
		interviewImpl.setExpireDate(interview.getExpireDate());
		interviewImpl.setQuestionSetId(interview.getQuestionSetId());
		interviewImpl.setResponse(interview.getResponse());

		return interviewImpl;
	}

	/**
	 * Returns the interview with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview
	 * @throws com.liferay.portal.NoSuchModelException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the interview with the primary key or throws a {@link com.liferay.interview.NoSuchInterviewException} if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview
	 * @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview findByPrimaryKey(long interviewId)
		throws NoSuchInterviewException, SystemException {
		Interview interview = fetchByPrimaryKey(interviewId);

		if (interview == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + interviewId);
			}

			throw new NoSuchInterviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				interviewId);
		}

		return interview;
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Interview fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview
	 * @return the interview, or <code>null</code> if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview fetchByPrimaryKey(long interviewId)
		throws SystemException {
		Interview interview = (Interview)EntityCacheUtil.getResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
				InterviewImpl.class, interviewId);

		if (interview == _nullInterview) {
			return null;
		}

		if (interview == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				interview = (Interview)session.get(InterviewImpl.class,
						Long.valueOf(interviewId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (interview != null) {
					cacheResult(interview);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InterviewModelImpl.ENTITY_CACHE_ENABLED,
						InterviewImpl.class, interviewId, _nullInterview);
				}

				closeSession(session);
			}
		}

		return interview;
	}

	/**
	 * Returns all the interviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @return the range of matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Interview> list = (List<Interview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Interview interview : list) {
				if (!Validator.equals(uuid, interview.getUuid())) {
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

			query.append(_SQL_SELECT_INTERVIEW_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

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

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Interview>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first interview in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview
	 * @throws com.liferay.interview.NoSuchInterviewException if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		List<Interview> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInterviewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last interview in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview
	 * @throws com.liferay.interview.NoSuchInterviewException if a matching interview could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		int count = countByUuid(uuid);

		List<Interview> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchInterviewException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the interviews before and after the current interview in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param interviewId the primary key of the current interview
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview
	 * @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Interview[] findByUuid_PrevAndNext(long interviewId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewException, SystemException {
		Interview interview = findByPrimaryKey(interviewId);

		Session session = null;

		try {
			session = openSession();

			Interview[] array = new InterviewImpl[3];

			array[0] = getByUuid_PrevAndNext(session, interview, uuid,
					orderByComparator, true);

			array[1] = interview;

			array[2] = getByUuid_PrevAndNext(session, interview, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Interview getByUuid_PrevAndNext(Session session,
		Interview interview, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEW_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

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

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interview);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Interview> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the interviews.
	 *
	 * @return the interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @return the range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of interviews
	 * @param end the upper bound of the range of interviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interviews
	 * @throws SystemException if a system exception occurred
	 */
	public List<Interview> findAll(int start, int end,
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

		List<Interview> list = (List<Interview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INTERVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEW;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Interview>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the interviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Interview interview : findByUuid(uuid)) {
			remove(interview);
		}
	}

	/**
	 * Removes all the interviews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Interview interview : findAll()) {
			remove(interview);
		}
	}

	/**
	 * Returns the number of interviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interviews
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTERVIEW_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of interviews.
	 *
	 * @return the number of interviews
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INTERVIEW);

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
	 * Initializes the interview persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.interview.model.Interview")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Interview>> listenersList = new ArrayList<ModelListener<Interview>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Interview>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InterviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = InterviewPersistence.class)
	protected InterviewPersistence interviewPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionSetPersistence.class)
	protected QuestionSetPersistence questionSetPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_INTERVIEW = "SELECT interview FROM Interview interview";
	private static final String _SQL_SELECT_INTERVIEW_WHERE = "SELECT interview FROM Interview interview WHERE ";
	private static final String _SQL_COUNT_INTERVIEW = "SELECT COUNT(interview) FROM Interview interview";
	private static final String _SQL_COUNT_INTERVIEW_WHERE = "SELECT COUNT(interview) FROM Interview interview WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "interview.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "interview.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(interview.uuid IS NULL OR interview.uuid = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Interview exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Interview exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InterviewPersistenceImpl.class);
	private static Interview _nullInterview = new InterviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Interview> toCacheModel() {
				return _nullInterviewCacheModel;
			}
		};

	private static CacheModel<Interview> _nullInterviewCacheModel = new CacheModel<Interview>() {
			public Interview toEntityModel() {
				return _nullInterview;
			}
		};
}