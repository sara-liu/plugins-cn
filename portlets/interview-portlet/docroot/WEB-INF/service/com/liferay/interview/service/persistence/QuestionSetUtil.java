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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the question set service. This utility wraps {@link QuestionSetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see QuestionSetPersistence
 * @see QuestionSetPersistenceImpl
 * @generated
 */
public class QuestionSetUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(QuestionSet questionSet) {
		getPersistence().clearCache(questionSet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuestionSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static QuestionSet update(QuestionSet questionSet, boolean merge)
		throws SystemException {
		return getPersistence().update(questionSet, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static QuestionSet update(QuestionSet questionSet, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(questionSet, merge, serviceContext);
	}

	/**
	* Caches the question set in the entity cache if it is enabled.
	*
	* @param questionSet the question set
	*/
	public static void cacheResult(
		com.liferay.interview.model.QuestionSet questionSet) {
		getPersistence().cacheResult(questionSet);
	}

	/**
	* Caches the question sets in the entity cache if it is enabled.
	*
	* @param questionSets the question sets
	*/
	public static void cacheResult(
		java.util.List<com.liferay.interview.model.QuestionSet> questionSets) {
		getPersistence().cacheResult(questionSets);
	}

	/**
	* Creates a new question set with the primary key. Does not add the question set to the database.
	*
	* @param questionSetId the primary key for the new question set
	* @return the new question set
	*/
	public static com.liferay.interview.model.QuestionSet create(
		long questionSetId) {
		return getPersistence().create(questionSetId);
	}

	/**
	* Removes the question set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set that was removed
	* @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.QuestionSet remove(
		long questionSetId)
		throws com.liferay.interview.NoSuchQuestionSetException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(questionSetId);
	}

	public static com.liferay.interview.model.QuestionSet updateImpl(
		com.liferay.interview.model.QuestionSet questionSet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(questionSet, merge);
	}

	/**
	* Returns the question set with the primary key or throws a {@link com.liferay.interview.NoSuchQuestionSetException} if it could not be found.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set
	* @throws com.liferay.interview.NoSuchQuestionSetException if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.QuestionSet findByPrimaryKey(
		long questionSetId)
		throws com.liferay.interview.NoSuchQuestionSetException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(questionSetId);
	}

	/**
	* Returns the question set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionSetId the primary key of the question set
	* @return the question set, or <code>null</code> if a question set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.QuestionSet fetchByPrimaryKey(
		long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(questionSetId);
	}

	/**
	* Returns all the question sets.
	*
	* @return the question sets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.interview.model.QuestionSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.interview.model.QuestionSet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.liferay.interview.model.QuestionSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the question sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question sets.
	*
	* @return the number of question sets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuestionSetPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionSetPersistence)PortletBeanLocatorUtil.locate(com.liferay.interview.service.ClpSerializer.getServletContextName(),
					QuestionSetPersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionSetUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(QuestionSetPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(QuestionSetUtil.class,
			"_persistence");
	}

	private static QuestionSetPersistence _persistence;
}