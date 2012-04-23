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

package com.liferay.interview.model.impl;

import com.liferay.interview.model.Interview;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Interview in entity cache.
 *
 * @author Sara Liu
 * @see Interview
 * @generated
 */
public class InterviewCacheModel implements CacheModel<Interview>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", interviewId=");
		sb.append(interviewId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", questionSetId=");
		sb.append(questionSetId);
		sb.append(", response=");
		sb.append(response);
		sb.append("}");

		return sb.toString();
	}

	public Interview toEntityModel() {
		InterviewImpl interviewImpl = new InterviewImpl();

		if (uuid == null) {
			interviewImpl.setUuid(StringPool.BLANK);
		}
		else {
			interviewImpl.setUuid(uuid);
		}

		interviewImpl.setInterviewId(interviewId);
		interviewImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			interviewImpl.setCreateDate(null);
		}
		else {
			interviewImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			interviewImpl.setModifiedDate(null);
		}
		else {
			interviewImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			interviewImpl.setName(StringPool.BLANK);
		}
		else {
			interviewImpl.setName(name);
		}

		if (emailAddress == null) {
			interviewImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			interviewImpl.setEmailAddress(emailAddress);
		}

		if (startDate == Long.MIN_VALUE) {
			interviewImpl.setStartDate(null);
		}
		else {
			interviewImpl.setStartDate(new Date(startDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			interviewImpl.setExpireDate(null);
		}
		else {
			interviewImpl.setExpireDate(new Date(expireDate));
		}

		interviewImpl.setQuestionSetId(questionSetId);

		if (response == null) {
			interviewImpl.setResponse(StringPool.BLANK);
		}
		else {
			interviewImpl.setResponse(response);
		}

		interviewImpl.resetOriginalValues();

		return interviewImpl;
	}

	public String uuid;
	public long interviewId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String emailAddress;
	public long startDate;
	public long expireDate;
	public long questionSetId;
	public String response;
}