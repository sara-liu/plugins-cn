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

package com.liferay.interview.portlet;

import com.liferay.interview.InterviewEmailAddressException;
import com.liferay.interview.InterviewNameException;
import com.liferay.interview.model.Interview;
import com.liferay.interview.service.InterviewLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class AdminPortlet extends MVCPortlet {

	public void deleteInterview(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long interviewId = ParamUtil.getLong(actionRequest, "interviewId");

		InterviewLocalServiceUtil.deleteInterview(interviewId);

		sendRedirect(actionRequest, actionResponse);
	}

	public void editInterview(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String currentURL = ParamUtil.getString(actionRequest, "currentURL");

		long interviewId = ParamUtil.getLong(actionRequest, "interviewId");
		long questionSetId = ParamUtil.getLong(actionRequest, "questionSetId");
		String name = ParamUtil.getString(actionRequest, "name");
		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		try {
			Interview interview = null;

			if (interviewId <= 0) {
				interview = InterviewLocalServiceUtil.addInterview(
					name, emailAddress, questionSetId, serviceContext);
			}
			else {
				interview = InterviewLocalServiceUtil.updateInterview(
					interviewId, name, emailAddress, questionSetId,
					serviceContext);
			}

			currentURL = HttpUtil.setParameter(
				currentURL, actionResponse.getNamespace() + "interviewId",
				interview.getInterviewId());
		}
		catch (Exception e) {
			if (e instanceof InterviewEmailAddressException ||
				e instanceof InterviewNameException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				actionResponse.setRenderParameter(
					"mvcPath", "/admin/edit_interview.jsp");
				actionResponse.setRenderParameter("redirect", currentURL);

				return;
			}
			else {
				throw e;
			}
		}

		actionRequest.setAttribute(WebKeys.REDIRECT, currentURL);

		sendRedirect(actionRequest, actionResponse);
	}

}