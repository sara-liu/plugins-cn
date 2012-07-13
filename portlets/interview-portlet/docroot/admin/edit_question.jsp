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

long questionId = ParamUtil.getLong(request, "questionId");

Question question = null;

try {
	question = QuestionLocalServiceUtil.getQuestion(questionId);

	long questionSetId = question.getQuestionSetId();
}
catch (NoSuchQuestionException nsqe) {
}

long questionSetId = ParamUtil.getLong(request, "questionSetId");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='<%= (question ==null) ? "new-question" : question.getTitle() %>'
/>

<portlet:actionURL name="updateQuestion" var="updateQuestionURL" />

<aui:form action="<%= updateQuestionURL %>" method="post" name="fm">
	<aui:model-context bean="<%= question %>" model="<%= Question.class %>" />

	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (question == null) ? Constants.ADD : Constants.EDIT %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="currentURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="questionSetId" type="hidden" value="<%= String.valueOf(questionSetId) %>" />
	<aui:input name="questionId" type="hidden" />

	<liferay-ui:error exception="<%= QuestionTitleException.class %>" message="please-enter-a-valid-title" />

	<aui:input name="title">
		<aui:validator name="required" />
	</aui:input>

	<aui:input cssClass="lfr-textarea-container" name="description" type="textarea" cols="52" rows="5" />

	<aui:select label="question-type" name="type">
		<aui:option label="one-line" selected="<%= (question != null) && (question.getType() == QuestionTypeConstants.ONE_LINE) %>" value="<%= QuestionTypeConstants.ONE_LINE %>" />
		<aui:option label="multi-line" selected="<%= (question != null) && (question.getType() == QuestionTypeConstants.MULTI_LINE) %>" value="<%= QuestionTypeConstants.MULTI_LINE %>" />
		<aui:option label="recorded" selected="<%= (question != null) && (question.getType() == QuestionTypeConstants.RECORDED) %>" value="<%= QuestionTypeConstants.RECORDED %>" />
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>