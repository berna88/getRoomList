package com.consistent.liferay.portal;


import com.consistent.interfaces.Constants;
import com.consistent.liferay.configuration.ConfigurationImpl;
import com.consistent.singleton.SingletonRest;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
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

import java.util.HashSet;
import java.util.List;

public abstract class Portal implements Constants{
	
	private static final Log log = LogFactoryUtil.getLog(Portal.class);
	static final SingletonRest rest = SingletonRest.getInstance();
	
	/**
	 * @author bernardohernandez
	 * @return devuelve el identificador de la carpeta Hotel
	 */
	protected Long getParentFolder() {
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
	protected Long getFolderIdBrand() {
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
	
	protected Long getFolderIdCodeHotel() {
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
	
	protected HashSet<JournalArticleImpl> getRoomsForBrand() throws PortalException{
		HashSet<JournalArticleImpl> articles = new HashSet<JournalArticleImpl>();
		DDMStructure results = DDMStructureLocalServiceUtil.getStructure(ConfigurationImpl.roomStructureId);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "Journal",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID,rest.getSiteIDLong()));
			dynamicQuery.add(RestrictionsFactoryUtil.like(TREEPATH, "%"+getFolderIdBrand()+"%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(DDMSTRUCTUREKEY, results.getStructureKey()));
			articles = new HashSet<>(JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery));
			log.info("Tamaño de articulos: "+articles.size());
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomsForBrand");
			e.fillInStackTrace();
		}
		return articles;
	}
	
	/**
	 * @author bernardohernandez
	 * @return Devuelve las habitaciones por codigo de hotel
	 * @throws PortalException
	 */
	
	protected HashSet<JournalArticleImpl> getRoomsForCodeHotel() throws PortalException{
		HashSet<JournalArticleImpl> articles = new HashSet<JournalArticleImpl>();
		DDMStructure results = DDMStructureLocalServiceUtil.getStructure(ConfigurationImpl.roomStructureId);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "Journal",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID,rest.getSiteIDLong()));
			dynamicQuery.add(RestrictionsFactoryUtil.like(TREEPATH, "%"+getFolderIdCodeHotel()+"%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(DDMSTRUCTUREKEY, results.getStructureKey()));
			articles = new HashSet<> (JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery));
			log.info("Tamaño de articulos: "+articles.size());
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomsForBrand");
			e.fillInStackTrace();
		}
		return articles;
	}
	
	protected HashSet<JournalArticleImpl> getAllRooms() throws PortalException{
		HashSet<JournalArticleImpl> articles = new HashSet<JournalArticleImpl>();
		DDMStructure results = DDMStructureLocalServiceUtil.getStructure(ConfigurationImpl.roomStructureId);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "Journal",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq(GROUPID,rest.getSiteIDLong()));
			dynamicQuery.add(RestrictionsFactoryUtil.like(TREEPATH, "%"+getParentFolder()+"%"));
			dynamicQuery.add(RestrictionsFactoryUtil.eq(DDMSTRUCTUREKEY, results.getStructureKey()));
			articles = new HashSet<>(JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery));
			log.info("Tamaño de articulos: "+articles.size());
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomsForBrand");
			e.fillInStackTrace();
		}
		return articles;
	}
	
	protected HashSet<JournalArticleImpl> validBrandOrHotelCode() throws PortalException{
		
		HashSet<JournalArticleImpl> articles = new HashSet<JournalArticleImpl>();
		
		if (rest.brandcode != null && !rest.brandcode.isEmpty() ) {
			articles = getRoomsForBrand();
		}else if(rest.hotelcode != null && !rest.hotelcode.isEmpty()) {
			articles = getRoomsForCodeHotel();
		}else if(rest.brandcode == null || rest.hotelcode == null) {
			log.info("Filtrado no valido");
		}else if(rest.brandcode.isEmpty() && rest.hotelcode.isEmpty()) {
			articles = getAllRooms();
		}else {
			log.info("Filtrado no valido"+rest.hotelcode);
		}
		return articles;
	}
	
	
}
