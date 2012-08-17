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
String startDate = ParamUtil.getString(request, "startDate");

Interview interview = null;

try {
	interview = InterviewLocalServiceUtil.getInterview(uuid);

	long questionSetId = interview.getQuestionSetId();

	List results = QuestionLocalServiceUtil.getQuestionSetQuestions(questionSetId);
%>

<c:if test="<%= Validator.isNull(interview.getResponse()) %>">
	<portlet:actionURL name="updateInterview" var="updateInterviewURL" />

	<aui:form action="<%= updateInterviewURL %>" method="post" name="fm" onSubmit="saveResponse()">

		<%@ include file="/display/show_questions.jspf" %>

		<aui:input name="interviewId" value="<%= String.valueOf(interview.getInterviewId()) %>" type="hidden" />
		<aui:input name="startDate" value="<%= startDate %>" type="hidden" />

		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:form>
</c:if>
<%
}
catch (IndexOutOfBoundsException e) {
}
catch (NullPointerException npe) {
}
%>
<aui:script>
	window.history.forward();
</aui:script>