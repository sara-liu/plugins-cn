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

import com.liferay.interview.model.Question;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author Sara Liu
 * @see Question
 * @generated
 */
public class QuestionCacheModel implements CacheModel<Question>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{questionId=");
		sb.append(questionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", questionSetId=");
		sb.append(questionSetId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", order=");
		sb.append(order);
		sb.append("}");

		return sb.toString();
	}

	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setQuestionId(questionId);
		questionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			questionImpl.setCreateDate(null);
		}
		else {
			questionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionImpl.setModifiedDate(null);
		}
		else {
			questionImpl.setModifiedDate(new Date(modifiedDate));
		}

		questionImpl.setQuestionSetId(questionSetId);

		if (title == null) {
			questionImpl.setTitle(StringPool.BLANK);
		}
		else {
			questionImpl.setTitle(title);
		}

		if (description == null) {
			questionImpl.setDescription(StringPool.BLANK);
		}
		else {
			questionImpl.setDescription(description);
		}

		questionImpl.setType(type);
		questionImpl.setOrder(order);

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	public long questionId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long questionSetId;
	public String title;
	public String description;
	public int type;
	public int order;
}