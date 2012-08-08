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
SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String uuid = PortalUtil.getOriginalServletRequest(request).getParameter("uuid");

long interviewId = 0;

try{
	interviewId = ParamUtil.getLong(request, "interviewId");
%>

	Tips:Once you start,you must finish in 2 hours...

	<portlet:renderURL var="updateInterviewURL">
		<portlet:param name="startDate" value="<%= format.format(new Date()) %>" />
		<portlet:param name="uuid" value="<%= uuid %>" />
		<portlet:param name="mvcPath" value="/display/view_questions.jsp" />
	</portlet:renderURL>

	<c:choose>
		<c:when test='<%= interviewId == 0 %>'>
			<aui:button-row>
				<aui:button onClick="<%= updateInterviewURL %>" value="start" />
			</aui:button-row>
		</c:when>
		<c:otherwise>
			<aui:button-row>
				<aui:button value="start" disabled = "true" />
			</aui:button-row>
		</c:otherwise>
	</c:choose>

<%
}
catch (NullPointerException npe) {
}
%>

<aui:script>
	window.history.forward();
</aui:script>