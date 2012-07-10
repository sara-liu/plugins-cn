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
String tabs1 = ParamUtil.getString(request, "tabs1", "interviews");
%>
dddd
<portlet:renderURL var="portletURL">
	<portlet:param name="mvcPath" value="/admin/view.jsp" />
	<portlet:param name="tabs1" value="<%= tabs1 %>" />
</portlet:renderURL>

<liferay-ui:tabs
	names="interviews,question-sets"
	param="tabs1"
	url="<%= portletURL %>"
/>

<c:choose>
	<c:when test='<%= tabs1.equals("interviews") %>'>
		<%@ include file="/admin/view_interviews.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("question-sets") %>'>
		<%@ include file="/admin/view_question_sets.jspf" %>
	</c:when>
</c:choose>