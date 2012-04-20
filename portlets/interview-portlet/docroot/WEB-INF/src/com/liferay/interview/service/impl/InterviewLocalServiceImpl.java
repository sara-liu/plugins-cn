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

import com.liferay.interview.NameException;
import com.liferay.interview.model.Interview;
import com.liferay.interview.service.base.InterviewLocalServiceBaseImpl;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the interview local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.interview.service.InterviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sara
 * @see com.liferay.interview.service.base.InterviewLocalServiceBaseImpl
 * @see com.liferay.interview.service.InterviewLocalServiceUtil
 */
public class InterviewLocalServiceImpl extends InterviewLocalServiceBaseImpl {

	public Interview addInterview(
			long userId, String name, String emailAddress, Date expireDate,
			long questionSetId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(name, emailAddress);

		long interviewId = counterLocalService.increment();

		Interview interview = interviewPersistence.create(interviewId);

		Date now = new Date();

		interview.setUuid(serviceContext.getUuid());
		interview.setUserId(serviceContext.getUserId());
		interview.setCreateDate(serviceContext.getCreateDate(now));
		interview.setModifiedDate(serviceContext.getModifiedDate(now));
		interview.setName(name);
		interview.setEmailAddress(emailAddress);
		interview.setExpireDate(expireDate);
		interview.setQuestionSetId(questionSetId);

		interviewPersistence.update(interview, false);

		return interview;
	}

	public Interview deleteInterview(long interviewId)
		throws PortalException, SystemException {

		interviewPersistence.remove(interviewId);

		return null;
	}

	public int getInterviewCount() throws SystemException {
		return interviewPersistence.countAll();
	}

	public List<Interview> getInterviews(int start, int end)
		throws SystemException {

		return interviewPersistence.findAll(start, end);
	}

	public Interview updateInterview(
			long interviewId, long questionSetId, long userId, String name,
			String emailAddress, Date expireDate, String response,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		validate(name, emailAddress);

		Interview interview = interviewPersistence.findByPrimaryKey(
			interviewId);

		Date now = new Date();

		interview.setQuestionSetId(questionSetId);
		interview.setUserId(userId);
		interview.setName(name);
		interview.setEmailAddress(emailAddress);
		interview.setModifiedDate(serviceContext.getModifiedDate(now));
		interview.setExpireDate(expireDate);
		interview.setResponse(response);

		interviewPersistence.updateImpl(interview, false);

		return interview;
	}

	protected void validate(String name, String emailAddress)
		throws PortalException, SystemException {

		if (!Validator.isEmailAddress(emailAddress)) {
			throw new UserEmailAddressException();
		}

		if (Validator.isNull(name)) {
			throw new NameException();
		}

		if (Validator.isNumber(name)) {
			throw new NameException();
		}
	}

}