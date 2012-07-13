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

import com.liferay.interview.QuestionTitleException;
import com.liferay.interview.model.Question;
import com.liferay.interview.service.base.QuestionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * @author Andy Yang
 */
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {

	public Question addQuestion(
			long questionSetId, String title, String description, int type,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(title);

		long questionId = counterLocalService.increment();

		Question question = questionPersistence.create(questionId);

		question.setUserId(serviceContext.getUserId());
		question.setCreateDate(serviceContext.getCreateDate(now));
		question.setModifiedDate(serviceContext.getModifiedDate(now));
		question.setQuestionSetId(questionSetId);
		question.setTitle(title);
		question.setDescription(description);
		question.setType(type);

		questionPersistence.update(question, false);

		return question;
	}

	public void deleteQuestionSetQuestions(long questionSetId)
		throws PortalException, SystemException {

		List<Question> questions = questionPersistence.findByQuestionSetId(
			questionSetId);

		for (Question question : questions) {
			deleteQuestion(question);
		}
	}

	public List<Question> getQuestionSetQuestions(
			long questionSetId, int start, int end)
		throws SystemException {

		return questionPersistence.findByQuestionSetId(questionSetId);
	}

	public int getQuestionSetQuestionsCount(long questionSetId)
		throws SystemException {

		return questionPersistence.countByQuestionSetId(questionSetId);
	}

	public Question updateQuestion(
			long questionId, long questionSetId, String title,
			String description, int type, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(title);

		Question question = questionPersistence.findByPrimaryKey(questionId);

		question.setUserId(serviceContext.getUserId());
		question.setModifiedDate(serviceContext.getModifiedDate(null));
		question.setQuestionSetId(questionSetId);
		question.setTitle(title);
		question.setDescription(description);
		question.setType(type);

		questionPersistence.updateImpl(question, false);

		return question;
	}

	protected void validate(String title) throws PortalException {

		if (Validator.isNull(title)) {
			throw new QuestionTitleException();
		}
	}

}