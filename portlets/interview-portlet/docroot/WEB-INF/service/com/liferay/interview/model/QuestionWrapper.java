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
 * This class is a wrapper for {@link Question}.
 * </p>
 *
 * @author    Sara Liu
 * @see       Question
 * @generated
 */
public class QuestionWrapper implements Question, ModelWrapper<Question> {
	public QuestionWrapper(Question question) {
		_question = question;
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

	/**
	* Returns the primary key of this question.
	*
	* @return the primary key of this question
	*/
	public long getPrimaryKey() {
		return _question.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question.
	*
	* @param primaryKey the primary key of this question
	*/
	public void setPrimaryKey(long primaryKey) {
		_question.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question ID of this question.
	*
	* @return the question ID of this question
	*/
	public long getQuestionId() {
		return _question.getQuestionId();
	}

	/**
	* Sets the question ID of this question.
	*
	* @param questionId the question ID of this question
	*/
	public void setQuestionId(long questionId) {
		_question.setQuestionId(questionId);
	}

	/**
	* Returns the user ID of this question.
	*
	* @return the user ID of this question
	*/
	public long getUserId() {
		return _question.getUserId();
	}

	/**
	* Sets the user ID of this question.
	*
	* @param userId the user ID of this question
	*/
	public void setUserId(long userId) {
		_question.setUserId(userId);
	}

	/**
	* Returns the user uuid of this question.
	*
	* @return the user uuid of this question
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _question.getUserUuid();
	}

	/**
	* Sets the user uuid of this question.
	*
	* @param userUuid the user uuid of this question
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_question.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this question.
	*
	* @return the create date of this question
	*/
	public java.util.Date getCreateDate() {
		return _question.getCreateDate();
	}

	/**
	* Sets the create date of this question.
	*
	* @param createDate the create date of this question
	*/
	public void setCreateDate(java.util.Date createDate) {
		_question.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this question.
	*
	* @return the modified date of this question
	*/
	public java.util.Date getModifiedDate() {
		return _question.getModifiedDate();
	}

	/**
	* Sets the modified date of this question.
	*
	* @param modifiedDate the modified date of this question
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_question.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the question set ID of this question.
	*
	* @return the question set ID of this question
	*/
	public long getQuestionSetId() {
		return _question.getQuestionSetId();
	}

	/**
	* Sets the question set ID of this question.
	*
	* @param questionSetId the question set ID of this question
	*/
	public void setQuestionSetId(long questionSetId) {
		_question.setQuestionSetId(questionSetId);
	}

	/**
	* Returns the title of this question.
	*
	* @return the title of this question
	*/
	public java.lang.String getTitle() {
		return _question.getTitle();
	}

	/**
	* Sets the title of this question.
	*
	* @param title the title of this question
	*/
	public void setTitle(java.lang.String title) {
		_question.setTitle(title);
	}

	/**
	* Returns the description of this question.
	*
	* @return the description of this question
	*/
	public java.lang.String getDescription() {
		return _question.getDescription();
	}

	/**
	* Sets the description of this question.
	*
	* @param description the description of this question
	*/
	public void setDescription(java.lang.String description) {
		_question.setDescription(description);
	}

	/**
	* Returns the type of this question.
	*
	* @return the type of this question
	*/
	public int getType() {
		return _question.getType();
	}

	/**
	* Sets the type of this question.
	*
	* @param type the type of this question
	*/
	public void setType(int type) {
		_question.setType(type);
	}

	/**
	* Returns the order of this question.
	*
	* @return the order of this question
	*/
	public int getOrder() {
		return _question.getOrder();
	}

	/**
	* Sets the order of this question.
	*
	* @param order the order of this question
	*/
	public void setOrder(int order) {
		_question.setOrder(order);
	}

	public boolean isNew() {
		return _question.isNew();
	}

	public void setNew(boolean n) {
		_question.setNew(n);
	}

	public boolean isCachedModel() {
		return _question.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_question.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _question.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _question.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_question.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _question.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_question.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionWrapper((Question)_question.clone());
	}

	public int compareTo(Question question) {
		return _question.compareTo(question);
	}

	@Override
	public int hashCode() {
		return _question.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Question> toCacheModel() {
		return _question.toCacheModel();
	}

	public Question toEscapedModel() {
		return new QuestionWrapper(_question.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _question.toString();
	}

	public java.lang.String toXmlString() {
		return _question.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_question.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Question getWrappedQuestion() {
		return _question;
	}

	public Question getWrappedModel() {
		return _question;
	}

	public void resetOriginalValues() {
		_question.resetOriginalValues();
	}

	private Question _question;
}