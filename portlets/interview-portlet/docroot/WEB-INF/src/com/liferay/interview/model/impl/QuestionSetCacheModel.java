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

import com.liferay.interview.model.QuestionSet;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing QuestionSet in entity cache.
 *
 * @author Sara Liu
 * @see QuestionSet
 * @generated
 */
public class QuestionSetCacheModel implements CacheModel<QuestionSet>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{questionSetId=");
		sb.append(questionSetId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", timeLimit=");
		sb.append(timeLimit);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	public QuestionSet toEntityModel() {
		QuestionSetImpl questionSetImpl = new QuestionSetImpl();

		questionSetImpl.setQuestionSetId(questionSetId);
		questionSetImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			questionSetImpl.setCreateDate(null);
		}
		else {
			questionSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionSetImpl.setModifiedDate(null);
		}
		else {
			questionSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		questionSetImpl.setTimeLimit(timeLimit);

		if (title == null) {
			questionSetImpl.setTitle(StringPool.BLANK);
		}
		else {
			questionSetImpl.setTitle(title);
		}

		questionSetImpl.resetOriginalValues();

		return questionSetImpl;
	}

	public long questionSetId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public int timeLimit;
	public String title;
}