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
 * This class is a wrapper for {@link InterviewLocalService}.
 * </p>
 *
 * @author    Sara Liu
 * @see       InterviewLocalService
 * @generated
 */
public class InterviewLocalServiceWrapper implements InterviewLocalService,
	ServiceWrapper<InterviewLocalService> {
	public InterviewLocalServiceWrapper(
		InterviewLocalService interviewLocalService) {
		_interviewLocalService = interviewLocalService;
	}

	/**
	* Adds the interview to the database. Also notifies the appropriate model listeners.
	*
	* @param interview the interview
	* @return the interview that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview addInterview(
		com.liferay.interview.model.Interview interview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.addInterview(interview);
	}

	/**
	* Creates a new interview with the primary key. Does not add the interview to the database.
	*
	* @param interviewId the primary key for the new interview
	* @return the new interview
	*/
	public com.liferay.interview.model.Interview createInterview(
		long interviewId) {
		return _interviewLocalService.createInterview(interviewId);
	}

	/**
	* Deletes the interview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewId the primary key of the interview
	* @throws PortalException if a interview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteInterview(long interviewId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_interviewLocalService.deleteInterview(interviewId);
	}

	/**
	* Deletes the interview from the database. Also notifies the appropriate model listeners.
	*
	* @param interview the interview
	* @throws SystemException if a system exception occurred
	*/
	public void deleteInterview(com.liferay.interview.model.Interview interview)
		throws com.liferay.portal.kernel.exception.SystemException {
		_interviewLocalService.deleteInterview(interview);
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
		return _interviewLocalService.dynamicQuery(dynamicQuery);
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
		return _interviewLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _interviewLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _interviewLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.interview.model.Interview fetchInterview(
		long interviewId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.fetchInterview(interviewId);
	}

	/**
	* Returns the interview with the primary key.
	*
	* @param interviewId the primary key of the interview
	* @return the interview
	* @throws PortalException if a interview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview getInterview(long interviewId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.getInterview(interviewId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.liferay.interview.model.Interview> getInterviews(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.getInterviews(start, end);
	}

	/**
	* Returns the number of interviews.
	*
	* @return the number of interviews
	* @throws SystemException if a system exception occurred
	*/
	public int getInterviewsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.getInterviewsCount();
	}

	/**
	* Updates the interview in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interview the interview
	* @return the interview that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview updateInterview(
		com.liferay.interview.model.Interview interview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateInterview(interview);
	}

	/**
	* Updates the interview in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interview the interview
	* @param merge whether to merge the interview with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the interview that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.interview.model.Interview updateInterview(
		com.liferay.interview.model.Interview interview, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateInterview(interview, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _interviewLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_interviewLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.interview.model.Interview addInterview(
		java.lang.String name, java.lang.String emailAddress,
		long questionSetId, int expireDateMonth, int expireDateDay,
		int expireDateYear, int expireDateHour, int expireDateMinute,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.addInterview(name, emailAddress,
			questionSetId, expireDateMonth, expireDateDay, expireDateYear,
			expireDateHour, expireDateMinute, serviceContext);
	}

	public com.liferay.interview.model.Interview getInterview(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.getInterview(uuid);
	}

	public com.liferay.interview.model.Interview updateInterview(
		long interviewId, java.lang.String name, java.lang.String emailAddress,
		java.util.Date startDate, java.util.Date expireDate,
		long questionSetId, java.lang.String response,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateInterview(interviewId, name,
			emailAddress, startDate, expireDate, questionSetId, response,
			serviceContext);
	}

	public com.liferay.interview.model.Interview updateInterview(
		long interviewId, java.lang.String name, java.lang.String emailAddress,
		long questionSetId, int expireDateMonth, int expireDateDay,
		int expireDateYear, int expireDateHour, int expireDateMinute,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateInterview(interviewId, name,
			emailAddress, questionSetId, expireDateMonth, expireDateDay,
			expireDateYear, expireDateHour, expireDateMinute, serviceContext);
	}

	public com.liferay.interview.model.Interview updateResponse(
		java.lang.String uuid, java.lang.String response,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateResponse(uuid, response,
			serviceContext);
	}

	public com.liferay.interview.model.Interview updateStartDate(
		java.lang.String uuid, java.util.Date startDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewLocalService.updateStartDate(uuid, startDate);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InterviewLocalService getWrappedInterviewLocalService() {
		return _interviewLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInterviewLocalService(
		InterviewLocalService interviewLocalService) {
		_interviewLocalService = interviewLocalService;
	}

	public InterviewLocalService getWrappedService() {
		return _interviewLocalService;
	}

	public void setWrappedService(InterviewLocalService interviewLocalService) {
		_interviewLocalService = interviewLocalService;
	}

	private InterviewLocalService _interviewLocalService;
}