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

<%@ include file="/display/init.jsp" %>

<%
String uuid = ParamUtil.getString(request, "uuid");

Interview interview = InterviewLocalServiceUtil.getInterview(uuid);

List<Question> questions = QuestionLocalServiceUtil.getQuestionSetQuestions(interview.getQuestionSetId());
%>

<portlet:actionURL name="updateInterview" var="updateInterviewURL" />

<aui:form action="<%= updateInterviewURL %>" method="post" name="fm">
	<aui:input name="uuid" value="<%= interview.getUuid() %>" type="hidden" />

	<%
	for (Question question : questions) {
	%>

		<aui:field-wrapper label="<%= HtmlUtil.escape(question.getTitle()) %>">
			<div class="description"><%= HtmlUtil.escape(question.getDescription()) %></div>

			<c:choose>
				<c:when test="<%= question.getType() == QuestionTypeConstants.ONE_LINE %>">
					<input id="<portlet:namespace />response<%= question.getQuestionId() %>" name="<portlet:namespace />response<%= question.getQuestionId() %>" type="input" />
				</c:when>
				<c:when test="<%= question.getType() == QuestionTypeConstants.MULTIPLE_LINES %>">
					<textarea id="<portlet:namespace />response<%= question.getQuestionId() %>"></textarea>
				</c:when>
			</c:choose>
		</aui:field-wrapper>

	<%
	}
	%>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>