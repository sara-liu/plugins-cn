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
String uuid = PortalUtil.getOriginalServletRequest(request).getParameter("uuid");

Interview interview = null;
Date startDate = null;
Date expireDate = null;
QuestionSet questionSet = null;
String interviewResponse = null;


try {
	interview = InterviewLocalServiceUtil.getInterview(uuid);

	startDate = interview.getStartDate();
	expireDate = interview.getExpireDate();
	questionSet = QuestionSetLocalServiceUtil.getQuestionSet(interview.getQuestionSetId());
	interviewResponse = interview.getResponse();
}
catch (Exception e) {
}

%>

<c:choose>
	<c:when test="<%= interview == null %>">
		<liferay-ui:message key="no-interview-selected" />
	</c:when>
	<c:when test="<%= Validator.isNotNull(interviewResponse) %>">
		<liferay-ui:message key="you-have-already-submitted-your-interview" />
	</c:when>
	<c:when test="<%= (interview != null) && InterviewUtil.isExpired(startDate, questionSet.getTimeLimit(), expireDate) %>">
		<liferay-ui:message key="interview-has-expired" />
	</c:when>
	<c:otherwise>
		Once you start, you must finish in <%= questionSet.getTimeLimit() %> minutes.

		<portlet:actionURL name="updateStartDate" var="updateStartDateURL">
			<portlet:param name="uuid" value="<%= uuid %>" />
		</portlet:actionURL>

		<aui:button-row>
			<aui:button onClick="<%= updateStartDateURL %>" value="start" />
		</aui:button-row>
	</c:otherwise>
</c:choose>