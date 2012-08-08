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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the question local service. This utility wraps {@link com.liferay.interview.service.impl.QuestionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see QuestionLocalService
 * @see com.liferay.interview.service.base.QuestionLocalServiceBaseImpl
 * @see com.liferay.interview.service.impl.QuestionLocalServiceImpl
 * @generated
 */
public class QuestionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.interview.service.impl.QuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the question to the database. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @return the question that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question addQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addQuestion(question);
	}

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public static com.liferay.interview.model.Question createQuestion(
		long questionId) {
		return getService().createQuestion(questionId);
	}

	/**
	* Deletes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @throws PortalException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestion(questionId);
	}

	/**
	* Deletes the question from the database. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestion(question);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.interview.model.Question fetchQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchQuestion(questionId);
	}

	/**
	* Returns the question with the primary key.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws PortalException if a question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question getQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestion(questionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.interview.model.Question> getQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestions(start, end);
	}

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	* @throws SystemException if a system exception occurred
	*/
	public static int getQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestionsCount();
	}

	/**
	* Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @return the question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question updateQuestion(
		com.liferay.interview.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateQuestion(question);
	}

	/**
	* Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param question the question
	* @param merge whether to merge the question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.interview.model.Question updateQuestion(
		com.liferay.interview.model.Question question, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateQuestion(question, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.liferay.interview.model.Question addQuestion(
		long questionSetId, java.lang.String title,
		java.lang.String description, int type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addQuestion(questionSetId, title, description, type,
			serviceContext);
	}

	public static void deleteQuestionSetQuestions(long questionSetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteQuestionSetQuestions(questionSetId);
	}

	public static java.util.List<com.liferay.interview.model.Question> getQuestionSetQuestions(
		long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestionSetQuestions(questionSetId);
	}

	public static java.util.List<com.liferay.interview.model.Question> getQuestionSetQuestions(
		long questionSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestionSetQuestions(questionSetId, start, end);
	}

	public static int getQuestionSetQuestionsCount(long questionSetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getQuestionSetQuestionsCount(questionSetId);
	}

	public static com.liferay.interview.model.Question updateQuestion(
		long questionId, java.lang.String title, java.lang.String description,
		int type, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateQuestion(questionId, title, description, type,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static QuestionLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					QuestionLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					QuestionLocalService.class.getName(), portletClassLoader);

			_service = new QuestionLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(QuestionLocalServiceUtil.class,
				"_service");
			MethodCache.remove(QuestionLocalService.class);
		}

		return _service;
	}

	public void setService(QuestionLocalService service) {
		MethodCache.remove(QuestionLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(QuestionLocalServiceUtil.class,
			"_service");
		MethodCache.remove(QuestionLocalService.class);
	}

	private static QuestionLocalService _service;
}