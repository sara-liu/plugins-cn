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

package com.liferay.interview.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link QuestionLocalService}.
 * </p>
 *
 * @author    Sara Liu
 * @see       QuestionLocalService
 * @generated
 */
public class QuestionLocalServiceWrapper implements QuestionLocalService,
	ServiceWrapper<QuestionLocalService> {
	public QuestionLocalServiceWrapper(
		QuestionLocalService questionLocalService) {
		_questionLocalService = questionLocalService;
	}

	/**
	* Adds the question to the database. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @return the question that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question addQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.addQuestion(question);
	}

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public com.liferay.interview.model.Question createQuestion(long questionId) {
		return _questionLocalService.createQuestion(questionId);
	}

	/**
	* Deletes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @return the question that was removed
	* @throws PortalException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.deleteQuestion(questionId);
	}

	/**
	* Deletes the question from the database. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @return the question that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question deleteQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.deleteQuestion(question);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.interview.model.Question fetchQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.fetchQuestion(questionId);
	}

	/**
	* Returns the question with the primary key.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws PortalException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question getQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getQuestion(questionId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.interview.model.Question> getQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getQuestions(start, end);
	}

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	* @throws SystemException if a system exception occurred
	*/
	public int getQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getQuestionsCount();
	}

	/**
	* Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @return the question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question updateQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.updateQuestion(question);
	}

	/**
	* Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @param merge whether to merge the question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Question updateQuestion(
		com.liferay.interview.model.Question question, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.updateQuestion(question, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _questionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_questionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.interview.model.Question addQuestion(
		java.lang.String title, java.lang.String description,
		long questionSetId, int type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.addQuestion(title, description,
			questionSetId, type, serviceContext);
	}

	public void deleteQuestionSetQuestions(long questionSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_questionLocalService.deleteQuestionSetQuestions(questionSetId);
	}

	public java.util.List<com.liferay.interview.model.Question> getQuestionSetQuestions(
		long questionSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getQuestionSetQuestions(questionSetId,
			start, end);
	}

	public int getQuestionSetQuestionsCount(long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.getQuestionSetQuestionsCount(questionSetId);
	}

	public com.liferay.interview.model.Question updateQuestion(
		long questionId, long questionSetId, java.lang.String title,
		java.lang.String description, int type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _questionLocalService.updateQuestion(questionId, questionSetId,
			title, description, type, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public QuestionLocalService getWrappedQuestionLocalService() {
		return _questionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedQuestionLocalService(
		QuestionLocalService questionLocalService) {
		_questionLocalService = questionLocalService;
	}

	public QuestionLocalService getWrappedService() {
		return _questionLocalService;
	}

	public void setWrappedService(QuestionLocalService questionLocalService) {
		_questionLocalService = questionLocalService;
	}

	private QuestionLocalService _questionLocalService;
}