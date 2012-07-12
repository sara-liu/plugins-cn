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
String redirect = ParamUtil.getString(request, "redirect");
long questionSetId = ParamUtil.getLong(request, "questionSetId");
System.out.println("rrrrrrrr=="+questionSetId);
String title = ParamUtil.getString(request, "title");

QuestionSet questionSet = null;

try {
	questionSet = QuestionSetLocalServiceUtil.getQuestionSet(questionSetId);
}
catch (NoSuchQuestionSetException nsqse) {
}
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= (questionSet ==null) ? "new-question-set" : questionSet.getTitle() %>'
/>

<portlet:actionURL name="updateQuestionSet" var="updateQuestionSetURL" />

<aui:form action="<%= updateQuestionSetURL %>" method="post" name="fm">
	<aui:model-context bean="<%= questionSet %>" model="<%= QuestionSet.class %>" />

	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="currentURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="questionSetId" type="hidden" value="<%= String.valueOf(questionSetId)%>"/>

	<liferay-ui:error exception="<%= QuestionSetTitleException.class %>" message="please-enter-a-valid-title" />

	<aui:input name="title" value="<%= title%>">
		<aui:validator name="required" />
	</aui:input>

	<aui:button type="submit" />
</aui:form>
