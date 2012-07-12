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
long questionId = ParamUtil.getLong(request, "questionId");
String title = ParamUtil.getString(request, "title");
String description = ParamUtil.getString(request, "description");

Question question = null;
try {
	question = QuestionLocalServiceUtil.getQuestion(questionId);
}
catch (NoSuchQuestionException nsqe) {
}
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= (question ==null) ? "new-question" : question.getTitle()%>'
/>

<portlet:actionURL name="updateQuestion" var="updateQuestionURL" />

<aui:form action="<%= updateQuestionURL %>" method="post" name="fm1">
	<aui:model-context bean="<%= question %>" model="<%= Question.class %>" />

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (question == null) ? Constants.ADD : Constants.EDIT %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="currentURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="questionSetId" type="hidden" value="<%= String.valueOf(questionSetId) %>" />
	<aui:input name="questionId" type="hidden" value="<%= String.valueOf(questionId) %>" />

	<liferay-ui:error exception="<%= QuestionTitleException.class %>" message="please-enter-a-valid-title" />

	<aui:input name="title" value="<%= title%>">
		<aui:validator name="required" />
	</aui:input>

	<aui:input cssClass="lfr-textarea-container" label="Description" name="Description" type="textarea" value="<%= description %>"/>

	<aui:select label="question-type" name="type">
		<aui:option label="one-line" selected="one-line" />
		<aui:option label="mulfi-line" selected="mulfi-line" />
		<aui:option label="recorded" selected="recorded" />
	</aui:select>

	<aui:button type="submit" />
</aui:form>