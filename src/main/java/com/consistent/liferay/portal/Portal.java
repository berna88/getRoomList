package com.consistent.liferay.portal;


import com.consistent.interfaces.Constants;
import com.consistent.liferay.configuration.ConfigurationImpl;
import com.consistent.singleton.SingletonRest;
import com.liferay.journal.model.impl.JournalFolderImpl;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.List;

public abstract class Portal implements Constants{
	
	private static final Log log = LogFactoryUtil.getLog(Portal.class);
	static final SingletonRest rest = SingletonRest.getInstance();
	
	public static Long getParentFolder() {
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(NAME, ConfigurationImpl.parentFolder));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID, rest.getSiteIDLong()));
			List<JournalFolderImpl> listFolder = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = listFolder.get(0).getFolderId();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getParentFolder");
			e.fillInStackTrace();
		}
		return folderId;
	}
	
	public static Long getFolderIdBrand() {
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(NAME, rest.brandcode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(PARENTFOLDERID, getParentFolder()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID, rest.getSiteIDLong()));
			List<JournalFolderImpl> listFolder = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = listFolder.get(0).getFolderId();
			log.info("folderId"+folderId);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getFolderIdBrand");
			e.fillInStackTrace();
		}
		return folderId;
	}
	
	
}
