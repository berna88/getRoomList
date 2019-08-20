package com.consistent.singleton;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SingletonRest {
	private static final Log log = LogFactoryUtil.getLog(SingletonRest.class);
	private static SingletonRest singletonRest = null;
	
	public String siteID;
	public String language;
	public String channel;
	public String brandcode;
	public String hotelcode;
	
	public static SingletonRest getInstance() {
		if(singletonRest == null)
			singletonRest = new SingletonRest();
			
		return singletonRest;
	}
	
	public Long getSiteIDLong() {
		return new Long(siteID);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Site ID: "+siteID+ " Language: "+ language+" Channel: "+ channel+ " BrandCode "+ brandcode+ " HotelCode: "+hotelcode;
	}
	//Metodo para obtener el locate
	public String getLanguaje(){	
		if(language.equalsIgnoreCase("spanish")){
			return  "es_ES";
		}else if(language.equalsIgnoreCase("english")){
			return "en_US";
		}else {
			log.info("No se establecio un lenguaje valido");
		}
		return new String();			
	}
}
