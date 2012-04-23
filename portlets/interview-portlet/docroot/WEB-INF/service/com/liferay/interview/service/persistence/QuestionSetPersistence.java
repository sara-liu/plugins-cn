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

import com.liferay.interview.model.QuestionSet;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the question set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see QuestionSetPersistenceImpl
 * @see QuestionSetUtil
 * @generated
 */
public interface QuestionSetPersistence extends BasePersistence<QuestionSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionSetUtil} to access the question set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the question set in the entity cache if it is enabled.
	*
	* @param questionSet the question set
	*/
	public void cacheResult(com.liferay.interview.model.QuestionSet questionSet);

	/**
	* Caches the question sets in the entity cache if it is enabled.
	*
	* @param questionSets the question sets
	*/
	public void cacheResult(
		java.util.List<com.liferay.interview.model.QuestionSet> questionSets);

	/**
	* Creates a new question set with the primary key. Does not add the question set to the database.
	*
	* @param questionSetId the primary key for the new question set
	* @return the new question set
	*/
	public com.liferay.interview.model.QuestionSet create(long questionSetId);

	/**
	* Removes the question set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set that was removed
	* @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.QuestionSet remove(long questionSetId)
		throws com.liferay.interview.NoSuchQuestionSetException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.interview.model.QuestionSet updateImpl(
		com.liferay.interview.model.QuestionSet questionSet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question set with the primary key or throws a {@link com.liferay.interview.NoSuchQuestionSetException} if it could not be found.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set
	* @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.QuestionSet findByPrimaryKey(
		long questionSetId)
		throws com.liferay.interview.NoSuchQuestionSetException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the question set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set, or <code>null</code> if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.QuestionSet fetchByPrimaryKey(
		long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the question sets.
	*
	* @return the question sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.interview.model.QuestionSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.QuestionSet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.interview.model.QuestionSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the question sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of question sets.
	*
	* @return the number of question sets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}