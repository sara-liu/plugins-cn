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

package com.liferay.interview;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Sara Liu
 */
public class QuestionSetTitleException extends PortalException {

	public QuestionSetTitleException() {
		super();
	}

	public QuestionSetTitleException(String msg) {
		super(msg);
	}

	public QuestionSetTitleException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public QuestionSetTitleException(Throwable cause) {
		super(cause);
	}

}