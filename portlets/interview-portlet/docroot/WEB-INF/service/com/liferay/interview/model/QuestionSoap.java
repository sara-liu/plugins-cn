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
public class QuestionSoap implements Serializable {
	public static QuestionSoap toSoapModel(Question model) {
		QuestionSoap soapModel = new QuestionSoap();

		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQuestionSetId(model.getQuestionSetId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setOrder(model.getOrder());

		return soapModel;
	}

	public static QuestionSoap[] toSoapModels(Question[] models) {
		QuestionSoap[] soapModels = new QuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[][] toSoapModels(Question[][] models) {
		QuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[] toSoapModels(List<Question> models) {
		List<QuestionSoap> soapModels = new ArrayList<QuestionSoap>(models.size());

		for (Question model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionSoap[soapModels.size()]);
	}

	public QuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
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

	public long getQuestionSetId() {
		return _questionSetId;
	}

	public void setQuestionSetId(long questionSetId) {
		_questionSetId = questionSetId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	private long _questionId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _questionSetId;
	private String _title;
	private String _description;
	private int _type;
	private int _order;
}