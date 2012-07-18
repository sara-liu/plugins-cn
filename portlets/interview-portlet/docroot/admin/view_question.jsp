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
String backURL = ParamUtil.getString(request, "backURL");

long questionSetId = ParamUtil.getLong(request, "questionSetId");

QuestionSet questionSet = null;

try {
	questionSet = QuestionSetLocalServiceUtil.getQuestionSet(questionSetId);
}
catch (NoSuchQuestionSetException nsqse) {
}
%>

<c:choose>
	<c:when test="<%= questionSet != null %>">
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
			<aui:button onClick="<%= editquestionURL %>" value="add-question" />
		</aui:button-row>

		<liferay-ui:search-container
			emptyResultsMessage="there-are-no-questions"
			headerNames="title"
		>
			<liferay-ui:search-container-results
				results="<%= QuestionLocalServiceUtil.getQuestionSetQuestions(questionSetId, searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%= QuestionLocalServiceUtil.getQuestionSetQuestionsCount(questionSetId) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.interview.model.Question"
				escapedModel="<%= true %>"
				keyProperty="questionId"
				modelVar="question"
			>

				<portlet:renderURL var="rowURL">
					<portlet:param name="mvcPath" value="/admin/edit_question.jsp" />
					<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text
					href="<%= rowURL %>"
					name="title"
					value="<%= question.getTitle() %>"
				/>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/admin/question_action.jsp"
				/>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<liferay-ui:error message="invalid-question-set-id">
	</c:otherwise>
</c:choose>