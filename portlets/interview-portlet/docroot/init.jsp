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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.interview.NoSuchInterviewException" %><%@
page import="com.liferay.interview.NoSuchQuestionException" %><%@
page import="com.liferay.interview.NoSuchQuestionSetException" %><%@
page import="com.liferay.interview.model.Interview" %><%@
page import="com.liferay.interview.model.Question" %><%@
page import="com.liferay.interview.model.QuestionSet" %><%@
page import="com.liferay.interview.service.InterviewLocalServiceUtil" %><%@
page import="com.liferay.interview.service.QuestionLocalServiceUtil" %><%@
page import="com.liferay.interview.service.QuestionSetLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="javax.portlet.PortletURL" %>

<portlet:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
%>