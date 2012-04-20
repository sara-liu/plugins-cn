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

package com.liferay.interview.service.impl;

import com.liferay.interview.QuestionSetTitleException;
import com.liferay.interview.model.Question;
import com.liferay.interview.model.QuestionSet;
import com.liferay.interview.service.base.QuestionSetLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the question set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.interview.service.QuestionSetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara Liu
 * @see com.liferay.interview.service.base.QuestionSetLocalServiceBaseImpl
 * @see com.liferay.interview.service.QuestionSetLocalServiceUtil
 */
public class QuestionSetLocalServiceImpl
	extends QuestionSetLocalServiceBaseImpl {

	public QuestionSet addQuestionSet(
			long userId, String title, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(title);

		Date now = new Date();

		long questionSetId = counterLocalService.increment();

		QuestionSet questionSet = questionSetPersistence.create(questionSetId);

		questionSet.setTitle(title);
		questionSet.setUserId(userId);
		questionSet.setCreateDate(serviceContext.getCreateDate(now));
		questionSet.setModifiedDate(serviceContext.getModifiedDate(now));

		questionSetPersistence.update(questionSet, false);

		return questionSet;
	}

	public QuestionSet deleteSet(long questionSetId)
		throws PortalException, SystemException{

		QuestionSet questionSet = questionSetPersistence.findByPrimaryKey(
			questionSetId);

		List<Question> questions = questionPersistence.findByQuestionSetId(
			questionSetId);

		questionLocalService.deleteQuestion(questions);

		deleteQuestionSet(questionSet);

		return questionSet;
	}

	public int getQuestionSetCount() throws SystemException {
		return questionSetPersistence.countAll();
	}

	public List<QuestionSet> getQuestionSets(int start, int end)
		throws SystemException {

		return questionSetPersistence.findAll(start, end);
	}

	public QuestionSet updateQuestionSet(
			long questionSetId, long userId, String title,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		QuestionSet questionSet = questionSetPersistence.findByPrimaryKey(
			questionSetId);

		validate(title);

		questionSet.setUserId(userId);
		questionSet.setModifiedDate(serviceContext.getModifiedDate(null));
		questionSet.setTitle(title);

		questionSetPersistence.updateImpl(questionSet, false);

		return questionSet;
	}

	private void validate(String title)
		throws PortalException, SystemException {

		if (Validator.isNull(title)) {
			throw new QuestionSetTitleException();
		}
	}

}