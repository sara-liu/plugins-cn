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

import com.liferay.interview.model.Question;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the question service. This utility wraps {@link QuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sara Liu
 * @see QuestionPersistence
 * @see QuestionPersistenceImpl
 * @generated
 */
public class QuestionUtil {
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
	public static void clearCache(Question question) {
		getPersistence().clearCache(question);
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
	public static List<Question> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Question update(Question question, boolean merge)
		throws SystemException {
		return getPersistence().update(question, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Question update(Question question, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(question, merge, serviceContext);
	}

	/**
	* Caches the question in the entity cache if it is enabled.
	*
	* @param question the question
	*/
	public static void cacheResult(
		com.liferay.interview.model.Question question) {
		getPersistence().cacheResult(question);
	}

	/**
	* Caches the questions in the entity cache if it is enabled.
	*
	* @param questions the questions
	*/
	public static void cacheResult(
		java.util.List<com.liferay.interview.model.Question> questions) {
		getPersistence().cacheResult(questions);
	}

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public static com.liferay.interview.model.Question create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	* Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @return the question that was removed
	* @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question remove(long questionId)
		throws com.liferay.interview.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(questionId);
	}

	public static com.liferay.interview.model.Question updateImpl(
		com.liferay.interview.model.Question question, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(question, merge);
	}

	/**
	* Returns the question with the primary key or throws a {@link com.liferay.interview.NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws com.liferay.interview.NoSuchQuestionException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question findByPrimaryKey(
		long questionId)
		throws com.liferay.interview.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	* Returns the question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question, or <code>null</code> if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question fetchByPrimaryKey(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	/**
	* Returns all the questions where questionSetId = &#63;.
	*
	* @param questionSetId the question set ID
	* @return the matching questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.interview.model.Question> findByQuestionSetId(
		long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionSetId(questionSetId);
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
	public static java.util.List<com.liferay.interview.model.Question> findByQuestionSetId(
		long questionSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionSetId(questionSetId, start, end);
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
	public static java.util.List<com.liferay.interview.model.Question> findByQuestionSetId(
		long questionSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionSetId(questionSetId, start, end,
			orderByComparator);
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
	public static com.liferay.interview.model.Question findByQuestionSetId_First(
		long questionSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionSetId_First(questionSetId, orderByComparator);
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
	public static com.liferay.interview.model.Question findByQuestionSetId_Last(
		long questionSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionSetId_Last(questionSetId, orderByComparator);
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
	public static com.liferay.interview.model.Question[] findByQuestionSetId_PrevAndNext(
		long questionId, long questionSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.interview.NoSuchQuestionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionSetId_PrevAndNext(questionId, questionSetId,
			orderByComparator);
	}

	/**
	* Returns all the questions.
	*
	* @return the questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.interview.model.Question> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.interview.model.Question> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.liferay.interview.model.Question> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the questions where questionSetId = &#63; from the database.
	*
	* @param questionSetId the question set ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionSetId(long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionSetId(questionSetId);
	}

	/**
	* Removes all the questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of questions where questionSetId = &#63;.
	*
	* @param questionSetId the question set ID
	* @return the number of matching questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionSetId(long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionSetId(questionSetId);
	}

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionPersistence)PortletBeanLocatorUtil.locate(com.liferay.interview.service.ClpSerializer.getServletContextName(),
					QuestionPersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(QuestionPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(QuestionUtil.class, "_persistence");
	}

	private static QuestionPersistence _persistence;
}