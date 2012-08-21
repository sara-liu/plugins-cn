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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Sara Liu
 * @generated
 */
public class QuestionSetSoap implements Serializable {
	public static QuestionSetSoap toSoapModel(QuestionSet model) {
		QuestionSetSoap soapModel = new QuestionSetSoap();

		soapModel.setQuestionSetId(model.getQuestionSetId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setTimeLimit(model.getTimeLimit());

		return soapModel;
	}

	public static QuestionSetSoap[] toSoapModels(QuestionSet[] models) {
		QuestionSetSoap[] soapModels = new QuestionSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionSetSoap[][] toSoapModels(QuestionSet[][] models) {
		QuestionSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionSetSoap[] toSoapModels(List<QuestionSet> models) {
		List<QuestionSetSoap> soapModels = new ArrayList<QuestionSetSoap>(models.size());

		for (QuestionSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionSetSoap[soapModels.size()]);
	}

	public QuestionSetSoap() {
	}

	public long getPrimaryKey() {
		return _questionSetId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionSetId(pk);
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

	private long _questionSetId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private int _timeLimit;
}