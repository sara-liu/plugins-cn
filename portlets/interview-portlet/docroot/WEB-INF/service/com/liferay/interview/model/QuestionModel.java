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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Question service. Represents a row in the &quot;Interview_Question&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.interview.model.impl.QuestionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.interview.model.impl.QuestionImpl}.
 * </p>
 *
 * @author Sara Liu
 * @see Question
 * @see com.liferay.interview.model.impl.QuestionImpl
 * @see com.liferay.interview.model.impl.QuestionModelImpl
 * @generated
 */
public interface QuestionModel extends BaseModel<Question> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a question model instance should use the {@link Question} interface instead.
	 */

	/**
	 * Returns the primary key of this question.
	 *
	 * @return the primary key of this question
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this question.
	 *
	 * @param primaryKey the primary key of this question
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the question ID of this question.
	 *
	 * @return the question ID of this question
	 */
	public long getQuestionId();

	/**
	 * Sets the question ID of this question.
	 *
	 * @param questionId the question ID of this question
	 */
	public void setQuestionId(long questionId);

	/**
	 * Returns the user ID of this question.
	 *
	 * @return the user ID of this question
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this question.
	 *
	 * @param userId the user ID of this question
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this question.
	 *
	 * @return the user uuid of this question
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this question.
	 *
	 * @param userUuid the user uuid of this question
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this question.
	 *
	 * @return the create date of this question
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this question.
	 *
	 * @param createDate the create date of this question
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this question.
	 *
	 * @return the modified date of this question
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this question.
	 *
	 * @param modifiedDate the modified date of this question
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the question set ID of this question.
	 *
	 * @return the question set ID of this question
	 */
	public long getQuestionSetId();

	/**
	 * Sets the question set ID of this question.
	 *
	 * @param questionSetId the question set ID of this question
	 */
	public void setQuestionSetId(long questionSetId);

	/**
	 * Returns the title of this question.
	 *
	 * @return the title of this question
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this question.
	 *
	 * @param title the title of this question
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this question.
	 *
	 * @return the description of this question
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this question.
	 *
	 * @param description the description of this question
	 */
	public void setDescription(String description);

	/**
	 * Returns the type of this question.
	 *
	 * @return the type of this question
	 */
	public int getType();

	/**
	 * Sets the type of this question.
	 *
	 * @param type the type of this question
	 */
	public void setType(int type);

	/**
	 * Returns the order of this question.
	 *
	 * @return the order of this question
	 */
	public int getOrder();

	/**
	 * Sets the order of this question.
	 *
	 * @param order the order of this question
	 */
	public void setOrder(int order);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Question question);

	public int hashCode();

	public CacheModel<Question> toCacheModel();

	public Question toEscapedModel();

	public String toString();

	public String toXmlString();
}