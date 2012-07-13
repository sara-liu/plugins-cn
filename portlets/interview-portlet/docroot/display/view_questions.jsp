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

	PortletURL portletURL = renderResponse.createRenderURL();

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 0, portletURL, null, null);

	List results = QuestionLocalServiceUtil.getQuestionSetQuestions(questionSetId, searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setResults(results);
%>

<portlet:actionURL name="updateInterview" var="updateInterviewURL" />

<aui:form action="<%= updateInterviewURL %>" method="post" name="fm" onSubmit="saveResponse()">

	<%@ include file="/display/show_questions.jspf" %>

	<aui:input name="interviewId" value="<%= String.valueOf(interview.getInterviewId()) %>" type="hidden" />
	<aui:input name="startDate" value="<%= startDate %>" type="hidden" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<%
}
catch (IndexOutOfBoundsException e) {
}
catch (NullPointerException npe) {
}
%>
<aui:script>
	function saveResponse() {
		var response_temp = new Array(document.<portlet:namespace />fm.<portlet:namespace />response.length);

		for (var i = 0; i < document.<portlet:namespace />fm.<portlet:namespace />response.length; i++) {
			response_temp[i] = document.<portlet:namespace />fm.<portlet:namespace />response[i].value;
		}

		var json = {"response" : response_temp};

		var responseValue = document.<portlet:namespace />fm.<portlet:namespace />responseValue;
		var response = JSON.stringify(json);

		responseValue.value = response;

		submitForm(document.<portlet:namespace />fm);
	}
	window.history.forward();
</aui:script>