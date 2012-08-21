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

package com.liferay.interview.service;

import com.liferay.interview.model.InterviewClp;
import com.liferay.interview.model.QuestionClp;
import com.liferay.interview.model.QuestionSetClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"interview-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"interview-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "interview-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(InterviewClp.class.getName())) {
			return translateInputInterview(oldModel);
		}

		if (oldModelClassName.equals(QuestionClp.class.getName())) {
			return translateInputQuestion(oldModel);
		}

		if (oldModelClassName.equals(QuestionSetClp.class.getName())) {
			return translateInputQuestionSet(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputInterview(BaseModel<?> oldModel) {
		InterviewClp oldCplModel = (InterviewClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.interview.model.impl.InterviewImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setInterviewId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getInterviewId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value5 = oldCplModel.getName();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEmailAddress",
						new Class[] { String.class });

				String value6 = oldCplModel.getEmailAddress();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStartDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getStartDate();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setExpireDate",
						new Class[] { Date.class });

				Date value8 = oldCplModel.getExpireDate();

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setQuestionSetId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getQuestionSetId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setResponse",
						new Class[] { String.class });

				String value10 = oldCplModel.getResponse();

				method10.invoke(newModel, value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputQuestion(BaseModel<?> oldModel) {
		QuestionClp oldCplModel = (QuestionClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.interview.model.impl.QuestionImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setQuestionId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getQuestionId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getCreateDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getModifiedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setQuestionSetId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getQuestionSetId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value5 = oldCplModel.getTitle();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value6 = oldCplModel.getDescription();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setType",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getType());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setOrder",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getOrder());

				method8.invoke(newModel, value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputQuestionSet(BaseModel<?> oldModel) {
		QuestionSetClp oldCplModel = (QuestionSetClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.interview.model.impl.QuestionSetImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setQuestionSetId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getQuestionSetId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getCreateDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getModifiedDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value4 = oldCplModel.getTitle();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setTimeLimit",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getTimeLimit());

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.interview.model.impl.InterviewImpl")) {
			return translateOutputInterview(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.interview.model.impl.QuestionImpl")) {
			return translateOutputQuestion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.interview.model.impl.QuestionSetImpl")) {
			return translateOutputQuestionSet(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputInterview(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				InterviewClp newModel = new InterviewClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getInterviewId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setInterviewId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getCreateDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

				Method method5 = oldModelClass.getMethod("getName");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setName(value5);

				Method method6 = oldModelClass.getMethod("getEmailAddress");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setEmailAddress(value6);

				Method method7 = oldModelClass.getMethod("getStartDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setStartDate(value7);

				Method method8 = oldModelClass.getMethod("getExpireDate");

				Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

				newModel.setExpireDate(value8);

				Method method9 = oldModelClass.getMethod("getQuestionSetId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setQuestionSetId(value9);

				Method method10 = oldModelClass.getMethod("getResponse");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setResponse(value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputQuestion(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				QuestionClp newModel = new QuestionClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getQuestionId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setQuestionId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getCreateDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value2);

				Method method3 = oldModelClass.getMethod("getModifiedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value3);

				Method method4 = oldModelClass.getMethod("getQuestionSetId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setQuestionSetId(value4);

				Method method5 = oldModelClass.getMethod("getTitle");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setTitle(value5);

				Method method6 = oldModelClass.getMethod("getDescription");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setDescription(value6);

				Method method7 = oldModelClass.getMethod("getType");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setType(value7);

				Method method8 = oldModelClass.getMethod("getOrder");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setOrder(value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputQuestionSet(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				QuestionSetClp newModel = new QuestionSetClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getQuestionSetId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setQuestionSetId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getCreateDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value2);

				Method method3 = oldModelClass.getMethod("getModifiedDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value3);

				Method method4 = oldModelClass.getMethod("getTitle");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setTitle(value4);

				Method method5 = oldModelClass.getMethod("getTimeLimit");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setTimeLimit(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}