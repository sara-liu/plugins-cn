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
 * The implementation of the question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.interview.service.QuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Andy
 * @see com.liferay.interview.service.base.QuestionLocalServiceBaseImpl
 * @see com.liferay.interview.service.QuestionLocalServiceUtil
 */
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {

	public Question addQuestion(
			long userId, String title, String description,
			long questionSetId, int type, int order,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Question question = null;

		validate(title);

		long questionId = counterLocalService.increment();

		question = questionPersistence.create(questionId);

		Date now = new Date();

		question.setUserId(userId);
		question.setTitle(title);
		question.setDescription(description);
		question.setCreateDate(serviceContext.getCreateDate(now));
		question.setModifiedDate(serviceContext.getModifiedDate(now));
		question.setQuestionSetId(questionSetId);
		question.setType(type);
		question.setOrder(order);

		questionPersistence.update(question, false);

		return question;
	}

	public Question deleteQuestion(long questionId)
		throws PortalException, SystemException {

		Question question = questionPersistence.findByPrimaryKey(questionId);

		deleteQuestion(question);

		return question;
	}

	public void deleteQuestion(List<Question> questions)
		throws SystemException {

		for (Question question : questions) {
			deleteQuestion(question);
		}
	}

	public List<Question> getQuestions(long questionSetId, int start, int end)
		throws SystemException {

		List<Question> results = questionPersistence.findByQuestionSetId(
			questionSetId);

		return results;
	}

	public int getQuestionsCount(long questionSetId) throws SystemException {
		return questionPersistence.countByQuestionSetId(questionSetId);
	}

	public Question updateQuestion(
			long userId, String title, String description,
			long questionSetId, long questionId, int type, int order,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Question question = questionPersistence.findByPrimaryKey(questionId);

		validate(title);

		question.setUserId(userId);
		question.setModifiedDate(serviceContext.getModifiedDate(null));
		question.setTitle(title);
		question.setDescription(description);
		question.setType(type);
		question.setOrder(order);

		questionPersistence.updateImpl(question, false);

		return question;
	}

	private void validate(String title)
		throws PortalException, SystemException {

		if (Validator.isNull(title)) {
			throw new QuestionTitleException();
		}
	}

}