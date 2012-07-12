<%--
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
--%>
<%@ include file="/admin/init.jsp" %>
<%
long questionSetId = ParamUtil.getLong(request, "questionSetId");

QuestionSet questionSet = QuestionSetLocalServiceUtil.getQuestionSet(questionSetId);

String backURL = ParamUtil.getString(request, "backURL");
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= questionSet.getTitle() %>'
/>

<portlet:renderURL var="editquestionURL">
	<portlet:param name="mvcPath" value="/admin/edit_question.jsp" />
	<portlet:param name="questionSetId" value="<%= String.valueOf(questionSetId) %>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>
<aui:button-row>
	<aui:button onClick="<%= editquestionURL %>" value="add-new-question" />
</aui:button-row>

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-questions"
>
	<liferay-ui:search-container-results
			results ="<%= QuestionLocalServiceUtil.getQuestionSetQuestions(questionSetId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total = "<%= QuestionLocalServiceUtil.getQuestionSetQuestionsCount(questionSetId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.interview.model.Question"
		keyProperty="questionId"
		modelVar="question"
	>

		<portlet:renderURL var="rowURL">
			<portlet:param name="mvcPath" value="/admin/edit_question.jsp" />
			<portlet:param name="questionSetId" value="<%= String.valueOf(questionSetId) %>" />
			<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="title"
			value= "<%= question.getTitle() %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="description"
			value= "<%= question.getDescription() %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/admin/question_action.jsp"
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>