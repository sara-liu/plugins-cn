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
public class InterviewSoap implements Serializable {
	public static InterviewSoap toSoapModel(Interview model) {
		InterviewSoap soapModel = new InterviewSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setInterviewId(model.getInterviewId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setQuestionSetId(model.getQuestionSetId());
		soapModel.setResponse(model.getResponse());

		return soapModel;
	}

	public static InterviewSoap[] toSoapModels(Interview[] models) {
		InterviewSoap[] soapModels = new InterviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewSoap[][] toSoapModels(Interview[][] models) {
		InterviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewSoap[] toSoapModels(List<Interview> models) {
		List<InterviewSoap> soapModels = new ArrayList<InterviewSoap>(models.size());

		for (Interview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewSoap[soapModels.size()]);
	}

	public InterviewSoap() {
	}

	public long getPrimaryKey() {
		return _interviewId;
	}

	public void setPrimaryKey(long pk) {
		setInterviewId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getInterviewId() {
		return _interviewId;
	}

	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	public long getQuestionSetId() {
		return _questionSetId;
	}

	public void setQuestionSetId(long questionSetId) {
		_questionSetId = questionSetId;
	}

	public String getResponse() {
		return _response;
	}

	public void setResponse(String response) {
		_response = response;
	}

	private String _uuid;
	private long _interviewId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _emailAddress;
	private Date _startDate;
	private Date _expireDate;
	private long _questionSetId;
	private String _response;
}