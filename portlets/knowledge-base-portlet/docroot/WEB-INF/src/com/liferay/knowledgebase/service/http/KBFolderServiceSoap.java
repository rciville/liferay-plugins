/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.knowledgebase.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.knowledgebase.service.KBFolderServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.knowledgebase.service.KBFolderServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.knowledgebase.model.KBFolderSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.knowledgebase.model.KBFolder}, that is translated to a
 * {@link com.liferay.knowledgebase.model.KBFolderSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KBFolderServiceHttp
 * @see com.liferay.knowledgebase.model.KBFolderSoap
 * @see com.liferay.knowledgebase.service.KBFolderServiceUtil
 * @generated
 */
@ProviderType
public class KBFolderServiceSoap {
	public static com.liferay.knowledgebase.model.KBFolderSoap[] getFolders(
		long groupId, long parentKBFolderId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.liferay.knowledgebase.model.KBFolder> returnValue =
				KBFolderServiceUtil.getFolders(groupId, parentKBFolderId,
					start, end);

			return com.liferay.knowledgebase.model.KBFolderSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getFoldersCount(long groupId, long parentKBFolderId)
		throws RemoteException {
		try {
			int returnValue = KBFolderServiceUtil.getFoldersCount(groupId,
					parentKBFolderId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(KBFolderServiceSoap.class);
}