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
 * This class is a wrapper for {@link QuestionSet}.
 * </p>
 *
 * @author    Sara Liu
 * @see       QuestionSet
 * @generated
 */
public class QuestionSetWrapper implements QuestionSet,
	ModelWrapper<QuestionSet> {
	public QuestionSetWrapper(QuestionSet questionSet) {
		_questionSet = questionSet;
	}

	public Class<?> getModelClass() {
		return QuestionSet.class;
	}

	public String getModelClassName() {
		return QuestionSet.class.getName();
	}

	/**
	* Returns the primary key of this question set.
	*
	* @return the primary key of this question set
	*/
	public long getPrimaryKey() {
		return _questionSet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question set.
	*
	* @param primaryKey the primary key of this question set
	*/
	public void setPrimaryKey(long primaryKey) {
		_questionSet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question set ID of this question set.
	*
	* @return the question set ID of this question set
	*/
	public long getQuestionSetId() {
		return _questionSet.getQuestionSetId();
	}

	/**
	* Sets the question set ID of this question set.
	*
	* @param questionSetId the question set ID of this question set
	*/
	public void setQuestionSetId(long questionSetId) {
		_questionSet.setQuestionSetId(questionSetId);
	}

	/**
	* Returns the user ID of this question set.
	*
	* @return the user ID of this question set
	*/
	public long getUserId() {
		return _questionSet.getUserId();
	}

	/**
	* Sets the user ID of this question set.
	*
	* @param userId the user ID of this question set
	*/
	public void setUserId(long userId) {
		_questionSet.setUserId(userId);
	}

	/**
	* Returns the user uuid of this question set.
	*
	* @return the user uuid of this question set
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _questionSet.getUserUuid();
	}

	/**
	* Sets the user uuid of this question set.
	*
	* @param userUuid the user uuid of this question set
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_questionSet.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this question set.
	*
	* @return the create date of this question set
	*/
	public java.util.Date getCreateDate() {
		return _questionSet.getCreateDate();
	}

	/**
	* Sets the create date of this question set.
	*
	* @param createDate the create date of this question set
	*/
	public void setCreateDate(java.util.Date createDate) {
		_questionSet.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this question set.
	*
	* @return the modified date of this question set
	*/
	public java.util.Date getModifiedDate() {
		return _questionSet.getModifiedDate();
	}

	/**
	* Sets the modified date of this question set.
	*
	* @param modifiedDate the modified date of this question set
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_questionSet.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the time limit of this question set.
	*
	* @return the time limit of this question set
	*/
	public int getTimeLimit() {
		return _questionSet.getTimeLimit();
	}

	/**
	* Sets the time limit of this question set.
	*
	* @param timeLimit the time limit of this question set
	*/
	public void setTimeLimit(int timeLimit) {
		_questionSet.setTimeLimit(timeLimit);
	}

	/**
	* Returns the title of this question set.
	*
	* @return the title of this question set
	*/
	public java.lang.String getTitle() {
		return _questionSet.getTitle();
	}

	/**
	* Sets the title of this question set.
	*
	* @param title the title of this question set
	*/
	public void setTitle(java.lang.String title) {
		_questionSet.setTitle(title);
	}

	public boolean isNew() {
		return _questionSet.isNew();
	}

	public void setNew(boolean n) {
		_questionSet.setNew(n);
	}

	public boolean isCachedModel() {
		return _questionSet.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_questionSet.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _questionSet.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _questionSet.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_questionSet.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _questionSet.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_questionSet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionSetWrapper((QuestionSet)_questionSet.clone());
	}

	public int compareTo(com.liferay.interview.model.QuestionSet questionSet) {
		return _questionSet.compareTo(questionSet);
	}

	@Override
	public int hashCode() {
		return _questionSet.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.interview.model.QuestionSet> toCacheModel() {
		return _questionSet.toCacheModel();
	}

	public com.liferay.interview.model.QuestionSet toEscapedModel() {
		return new QuestionSetWrapper(_questionSet.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _questionSet.toString();
	}

	public java.lang.String toXmlString() {
		return _questionSet.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_questionSet.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public QuestionSet getWrappedQuestionSet() {
		return _questionSet;
	}

	public QuestionSet getWrappedModel() {
		return _questionSet;
	}

	public void resetOriginalValues() {
		_questionSet.resetOriginalValues();
	}

	private QuestionSet _questionSet;
}