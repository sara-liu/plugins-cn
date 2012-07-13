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

long interviewId = ParamUtil.getLong(request, "interviewId");

Interview interview = null;

try {
	interview = InterviewLocalServiceUtil.getInterview(interviewId);

	String responseDemo = interview.getResponse().replace("&#034", StringPool.QUOTE);

	JSONObject responseJSONObject = JSONFactoryUtil.createJSONObject(responseDemo);

	QuestionSet questionSet = QuestionSetLocalServiceUtil.getQuestionSet(interview.getQuestionSetId());

	PortletURL portletURL = renderResponse.createRenderURL();

	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 0, portletURL, null, null);

	List results = QuestionLocalServiceUtil.getQuestionSetQuestions(interview.getQuestionSetId(), searchContainer.getStart(), searchContainer.getEnd());

	searchContainer.setResults(results);
%>

	<aui:input type="hidden" name="responseJSONObject" value="<%= responseJSONObject %>" />

	<liferay-ui:header
		backURL="<%= backURL %>"
		title="<%= interview.getName() %>"
	/>

<%
	for (Object result : results) {
		Question question = (Question)result;
%>

		<div class="question-content">
			<table>
				<tr>
					<td>
						<%= question.getTitle() %>&nbsp;&nbsp;
					</td>
					<td>
						<%= question.getDescription() %>
					</td>
				</tr>
			</table>
		</div>

		<c:choose>
			<c:when test="<%= question.getType() == 1 %>">
				<aui:input label="" name="response" id="<%= question.getTitle() %>" disabled="true" />
			</c:when>
			<c:otherwise>
				<div class="question-response">
					<aui:input cssClass="lfr-textarea-container" cols="18" rows="6" id="<%= question.getTitle() %>" label="" name="response" type="textarea" value="" disabled="true" />
				</div>
			</c:otherwise>
		</c:choose>

<%
	}

}
catch (NoSuchInterviewException nsie) {
}
%>

<aui:script>
	var _json = document.getElementById("<portlet:namespace />responseJSONObject");
	var obj = eval("("+_json.value+")");
	var jsonArray = document.getElementsByName("<portlet:namespace />response");
	var i = 0;
	for (var j in obj) {
		jsonArray[i].value = obj[j];
		i++;
	}
</aui:script>