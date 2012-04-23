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

package com.liferay.interview.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Interview}.
 * </p>
 *
 * @author    Sara Liu
 * @see       Interview
 * @generated
 */
public class InterviewWrapper implements Interview, ModelWrapper<Interview> {
	public InterviewWrapper(Interview interview) {
		_interview = interview;
	}

	public Class<?> getModelClass() {
		return Interview.class;
	}

	public String getModelClassName() {
		return Interview.class.getName();
	}

	/**
	* Returns the primary key of this interview.
	*
	* @return the primary key of this interview
	*/
	public long getPrimaryKey() {
		return _interview.getPrimaryKey();
	}

	/**
	* Sets the primary key of this interview.
	*
	* @param primaryKey the primary key of this interview
	*/
	public void setPrimaryKey(long primaryKey) {
		_interview.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this interview.
	*
	* @return the uuid of this interview
	*/
	public java.lang.String getUuid() {
		return _interview.getUuid();
	}

	/**
	* Sets the uuid of this interview.
	*
	* @param uuid the uuid of this interview
	*/
	public void setUuid(java.lang.String uuid) {
		_interview.setUuid(uuid);
	}

	/**
	* Returns the interview ID of this interview.
	*
	* @return the interview ID of this interview
	*/
	public long getInterviewId() {
		return _interview.getInterviewId();
	}

	/**
	* Sets the interview ID of this interview.
	*
	* @param interviewId the interview ID of this interview
	*/
	public void setInterviewId(long interviewId) {
		_interview.setInterviewId(interviewId);
	}

	/**
	* Returns the user ID of this interview.
	*
	* @return the user ID of this interview
	*/
	public long getUserId() {
		return _interview.getUserId();
	}

	/**
	* Sets the user ID of this interview.
	*
	* @param userId the user ID of this interview
	*/
	public void setUserId(long userId) {
		_interview.setUserId(userId);
	}

	/**
	* Returns the user uuid of this interview.
	*
	* @return the user uuid of this interview
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interview.getUserUuid();
	}

	/**
	* Sets the user uuid of this interview.
	*
	* @param userUuid the user uuid of this interview
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_interview.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this interview.
	*
	* @return the create date of this interview
	*/
	public java.util.Date getCreateDate() {
		return _interview.getCreateDate();
	}

	/**
	* Sets the create date of this interview.
	*
	* @param createDate the create date of this interview
	*/
	public void setCreateDate(java.util.Date createDate) {
		_interview.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this interview.
	*
	* @return the modified date of this interview
	*/
	public java.util.Date getModifiedDate() {
		return _interview.getModifiedDate();
	}

	/**
	* Sets the modified date of this interview.
	*
	* @param modifiedDate the modified date of this interview
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_interview.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this interview.
	*
	* @return the name of this interview
	*/
	public java.lang.String getName() {
		return _interview.getName();
	}

	/**
	* Sets the name of this interview.
	*
	* @param name the name of this interview
	*/
	public void setName(java.lang.String name) {
		_interview.setName(name);
	}

	/**
	* Returns the email address of this interview.
	*
	* @return the email address of this interview
	*/
	public java.lang.String getEmailAddress() {
		return _interview.getEmailAddress();
	}

	/**
	* Sets the email address of this interview.
	*
	* @param emailAddress the email address of this interview
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_interview.setEmailAddress(emailAddress);
	}

	/**
	* Returns the start date of this interview.
	*
	* @return the start date of this interview
	*/
	public java.util.Date getStartDate() {
		return _interview.getStartDate();
	}

	/**
	* Sets the start date of this interview.
	*
	* @param startDate the start date of this interview
	*/
	public void setStartDate(java.util.Date startDate) {
		_interview.setStartDate(startDate);
	}

	/**
	* Returns the expire date of this interview.
	*
	* @return the expire date of this interview
	*/
	public java.util.Date getExpireDate() {
		return _interview.getExpireDate();
	}

	/**
	* Sets the expire date of this interview.
	*
	* @param expireDate the expire date of this interview
	*/
	public void setExpireDate(java.util.Date expireDate) {
		_interview.setExpireDate(expireDate);
	}

	/**
	* Returns the question set ID of this interview.
	*
	* @return the question set ID of this interview
	*/
	public long getQuestionSetId() {
		return _interview.getQuestionSetId();
	}

	/**
	* Sets the question set ID of this interview.
	*
	* @param questionSetId the question set ID of this interview
	*/
	public void setQuestionSetId(long questionSetId) {
		_interview.setQuestionSetId(questionSetId);
	}

	/**
	* Returns the response of this interview.
	*
	* @return the response of this interview
	*/
	public java.lang.String getResponse() {
		return _interview.getResponse();
	}

	/**
	* Sets the response of this interview.
	*
	* @param response the response of this interview
	*/
	public void setResponse(java.lang.String response) {
		_interview.setResponse(response);
	}

	public boolean isNew() {
		return _interview.isNew();
	}

	public void setNew(boolean n) {
		_interview.setNew(n);
	}

	public boolean isCachedModel() {
		return _interview.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_interview.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _interview.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _interview.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_interview.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _interview.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_interview.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InterviewWrapper((Interview)_interview.clone());
	}

	public int compareTo(com.liferay.interview.model.Interview interview) {
		return _interview.compareTo(interview);
	}

	@Override
	public int hashCode() {
		return _interview.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.interview.model.Interview> toCacheModel() {
		return _interview.toCacheModel();
	}

	public com.liferay.interview.model.Interview toEscapedModel() {
		return new InterviewWrapper(_interview.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _interview.toString();
	}

	public java.lang.String toXmlString() {
		return _interview.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_interview.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Interview getWrappedInterview() {
		return _interview;
	}

	public Interview getWrappedModel() {
		return _interview;
	}

	public void resetOriginalValues() {
		_interview.resetOriginalValues();
	}

	private Interview _interview;
}