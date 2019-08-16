package com.consistent.liferay.portal;


import com.consistent.interfaces.Constants;
import com.consistent.liferay.configuration.ConfigurationImpl;
import com.consistent.singleton.SingletonRest;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.impl.JournalArticleImpl;
import com.liferay.journal.model.impl.JournalFolderImpl;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class Portal implements Constants{
	
	private static final Log log = LogFactoryUtil.getLog(Portal.class);
	static final SingletonRest rest = SingletonRest.getInstance();
	
	/**
	 * @author bernardohernandez
	 * @return devuelve el identificador de la carpeta Hotel
	 */
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
	/**
	 * @author bernardohernandez
	 * @return devuelve el identificador de la carpeta de la marca
	 */
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
	
	/**
	 * @author bernardohernandez
	 * @return devuelve el identificador
	 */
	
	public static Long getFolderIdCodeHotel() {
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(NAME, rest.hotelcode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID, rest.getSiteIDLong()));
			List<JournalFolderImpl> listFolder = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = listFolder.get(0).getFolderId();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return folderId;
	}
	
	
	/**
	 * @author bernardohernandez
	 * @return
	 * @throws PortalException
	 */
	
	public static List<JournalArticle> getRoomsForBrand() throws PortalException{
		List<JournalArticle> articles = new ArrayList<JournalArticle>();
		DDMStructure results = DDMStructureLocalServiceUtil.getStructure(ConfigurationImpl.roomStructureId);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "Journal",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID,rest.getSiteIDLong()));
			dynamicQuery.add(RestrictionsFactoryUtil.like(TREEPATH, "%"+getFolderIdBrand()+"%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(DDMSTRUCTUREKEY, results.getStructureKey()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("version", 1.0));
			articles = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			log.info("Tamaño de articulos: "+articles.size());
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomsForBrand");
			e.fillInStackTrace();
		}
		return articles;
	}
	
	public static List<JournalArticle> getRoomsForCodeHotel() throws PortalException{
		List<JournalArticle> articles = new ArrayList<JournalArticle>();
		DDMStructure results = DDMStructureLocalServiceUtil.getStructure(ConfigurationImpl.roomStructureId);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "Journal",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID,rest.getSiteIDLong()));
			dynamicQuery.add(RestrictionsFactoryUtil.like(TREEPATH, "%"+getFolderIdCodeHotel()+"%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(DDMSTRUCTUREKEY, results.getStructureKey()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("version", 1.0));
			articles = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			log.info("Tamaño de articulos: "+articles.size());
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomsForBrand");
			e.fillInStackTrace();
		}
		return articles;
	}
	
	
}
