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
import com.liferay.interview.QuestionSetTitleException;
import com.liferay.interview.model.Interview;
import com.liferay.interview.model.Question;
import com.liferay.interview.model.QuestionSet;
import com.liferay.interview.service.InterviewLocalServiceUtil;
import com.liferay.interview.service.QuestionLocalServiceUtil;
import com.liferay.interview.service.QuestionSetLocalServiceUtil;
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

	public void updateInterview(
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

	public void deleteQuestionSet(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long questionSetId = ParamUtil.getLong(actionRequest, "questionSetId");

		QuestionSetLocalServiceUtil.deleteQuestionSet(questionSetId);

		sendRedirect(actionRequest, actionResponse);
	}

	public void updateQuestionSet(
			ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception{

		String currentURL = ParamUtil.getString(actionRequest, "currentURL");

		long questionSetId = ParamUtil.getLong(actionRequest, "questionSetId");
		System.out.println("3333333QuestionSetId==="+questionSetId);
		String title=ParamUtil.getString(actionRequest, "title");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		try {
			QuestionSet questionSet = null;

			if (questionSetId <= 0) {
				questionSet = QuestionSetLocalServiceUtil.addQuestionSet(
						title, serviceContext);
			}
			else {
				questionSet = QuestionSetLocalServiceUtil.updateQuestionSet(
						questionSetId, title, serviceContext);
			}

			currentURL = HttpUtil.setParameter(
				currentURL, actionResponse.getNamespace() + "questionSetId",
				questionSet.getQuestionSetId());
		}
		catch (Exception e) {
			if (e instanceof QuestionSetTitleException ) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				actionResponse.setRenderParameter(
					"mvcPath", "/admin/edit_questionSet.jsp");
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

	public void deleteQuestion(
			ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception{
		long questionId = ParamUtil.getLong(actionRequest, "questionId");

		QuestionLocalServiceUtil.deleteQuestion(questionId);

		sendRedirect(actionRequest, actionResponse);
	}

	public void updateQuestion(
			ActionRequest actionRequest, ActionResponse actionResponse) 
		throws Exception{
		String currentURL = ParamUtil.getString(actionRequest, "currentURL");

		long questionId = ParamUtil.getLong(actionRequest, "questionId");
		String title = actionRequest.getParameter("title");
		String description = actionRequest.getParameter("Description");
		String selected = actionRequest.getParameter("type");
		int type = 0;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			actionRequest);

		long questionSetId = ParamUtil.getLong(
				actionRequest, "questionSetId");
		if (selected.equals("one-line")) {
			type = 0;
		}else if (selected.equals("multi-line")) {
			type = 1;
		}else if (selected.equals("recorded")) {
			type = 2;
		}
		try {
			Question question = null;

			if (questionId <= 0) {
				question = QuestionLocalServiceUtil.addQuestion(
						title,  description, questionSetId, type,
						serviceContext);
			}
			else {
				question = QuestionLocalServiceUtil.updateQuestion(
						questionId, questionSetId, title, description, type,
						serviceContext);
			}

			currentURL = HttpUtil.setParameter(
				currentURL, actionResponse.getNamespace() + "questionSetId",
				question.getQuestionSetId());
		}
		catch (Exception e) {
			if (e instanceof QuestionSetTitleException ) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				actionResponse.setRenderParameter(
					"mvcPath", "/admin/edit_questionSet.jsp");
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