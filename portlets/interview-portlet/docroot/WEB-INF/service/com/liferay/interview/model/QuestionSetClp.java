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

import com.liferay.interview.service.QuestionSetLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Sara Liu
 */
public class QuestionSetClp extends BaseModelImpl<QuestionSet>
	implements QuestionSet {
	public QuestionSetClp() {
	}

	public Class<?> getModelClass() {
		return QuestionSet.class;
	}

	public String getModelClassName() {
		return QuestionSet.class.getName();
	}

	public long getPrimaryKey() {
		return _questionSetId;
	}

	public void setPrimaryKey(long primaryKey) {
		setQuestionSetId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_questionSetId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getQuestionSetId() {
		return _questionSetId;
	}

	public void setQuestionSetId(long questionSetId) {
		_questionSetId = questionSetId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getTimeLimit() {
		return _timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		_timeLimit = timeLimit;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionSetLocalServiceUtil.addQuestionSet(this);
		}
		else {
			QuestionSetLocalServiceUtil.updateQuestionSet(this);
		}
	}

	@Override
	public QuestionSet toEscapedModel() {
		return (QuestionSet)Proxy.newProxyInstance(QuestionSet.class.getClassLoader(),
			new Class[] { QuestionSet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionSetClp clone = new QuestionSetClp();

		clone.setQuestionSetId(getQuestionSetId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setTimeLimit(getTimeLimit());

		return clone;
	}

	public int compareTo(QuestionSet questionSet) {
		long primaryKey = questionSet.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QuestionSetClp questionSet = null;

		try {
			questionSet = (QuestionSetClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = questionSet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{questionSetId=");
		sb.append(getQuestionSetId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", timeLimit=");
		sb.append(getTimeLimit());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.interview.model.QuestionSet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionSetId</column-name><column-value><![CDATA[");
		sb.append(getQuestionSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeLimit</column-name><column-value><![CDATA[");
		sb.append(getTimeLimit());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionSetId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private int _timeLimit;
}