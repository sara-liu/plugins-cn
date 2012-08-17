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

import com.liferay.interview.TimeLimitExpiredException;
import com.liferay.interview.model.Interview;
import com.liferay.interview.service.InterviewLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class DisplayPortlet
 */
public class DisplayPortlet extends MVCPortlet {

	public void updateInterview(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws ParseException, PortalException, SystemException {

		long interviewId = ParamUtil.getLong(actionRequest, "interviewId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

		String responseDemo[] = actionRequest.getParameterValues("response");

		JSONObject json = JSONFactoryUtil.createJSONObject();

		try {
			for (int i = 0; i < responseDemo.length; i++) {
				json.put("question" + (i+1), responseDemo[i]);
			}

			String response = json.toString();

			InterviewLocalServiceUtil.updateResponse(
				interviewId, response, serviceContext);
		}
		catch (Exception e) {
			if (e instanceof TimeLimitExpiredException) {
				SessionErrors.add(actionRequest, e.getClass().getName());

				actionResponse.setRenderParameter(
					"mvcPath", "/display/view.jsp");
				actionResponse.setRenderParameter(
					"interviewId", String.valueOf(interviewId));

				return;
			}

		}

	}

	public void updateStartDate(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws ParseException, PortalException, SystemException{

		String uuid = ParamUtil.getString(actionRequest, "uuid");

		Interview interview = InterviewLocalServiceUtil.getInterview(uuid);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = format.parse(ParamUtil.getString(actionRequest,
			"startDate"));

		try{
			InterviewLocalServiceUtil.updateStartDate(
				interview.getInterviewId(), startDate, serviceContext);

			actionResponse.setRenderParameter(
				"mvcPath", "/display/view_questions.jsp");
			actionResponse.setRenderParameter("uuid", uuid);
		}
		catch (Exception e) {
			}
		}

}