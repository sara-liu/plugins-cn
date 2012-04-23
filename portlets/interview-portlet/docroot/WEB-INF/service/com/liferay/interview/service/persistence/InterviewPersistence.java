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

import com.liferay.interview.model.Interview;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the interview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see InterviewPersistenceImpl
 * @see InterviewUtil
 * @generated
 */
public interface InterviewPersistence extends BasePersistence<Interview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InterviewUtil} to access the interview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the interview in the entity cache if it is enabled.
	*
	* @param interview the interview
	*/
	public void cacheResult(com.liferay.interview.model.Interview interview);

	/**
	* Caches the interviews in the entity cache if it is enabled.
	*
	* @param interviews the interviews
	*/
	public void cacheResult(
		java.util.List<com.liferay.interview.model.Interview> interviews);

	/**
	* Creates a new interview with the primary key. Does not add the interview to the database.
	*
	* @param interviewId the primary key for the new interview
	* @return the new interview
	*/
	public com.liferay.interview.model.Interview create(long interviewId);

	/**
	* Removes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewId the primary key of the interview
	* @return the interview that was removed
	* @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview remove(long interviewId)
		throws com.liferay.interview.NoSuchInterviewException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.interview.model.Interview updateImpl(
		com.liferay.interview.model.Interview interview, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the interview with the primary key or throws a {@link com.liferay.interview.NoSuchInterviewException} if it could not be found.
	*
	* @param interviewId the primary key of the interview
	* @return the interview
	* @throws com.liferay.interview.NoSuchInterviewException if a interview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview findByPrimaryKey(
		long interviewId)
		throws com.liferay.interview.NoSuchInterviewException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the interview with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interviewId the primary key of the interview
	* @return the interview, or <code>null</code> if a interview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview fetchByPrimaryKey(
		long interviewId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the interviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching interviews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.interview.model.Interview> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.Interview> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.Interview> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.interview.model.Interview findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchInterviewException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.interview.model.Interview findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchInterviewException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.interview.model.Interview[] findByUuid_PrevAndNext(
		long interviewId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchInterviewException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the interviews.
	*
	* @return the interviews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.interview.model.Interview> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.Interview> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.Interview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the interviews where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the interviews from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of interviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching interviews
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of interviews.
	*
	* @return the number of interviews
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}