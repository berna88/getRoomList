package com.consistent.singleton;

public class SingletonRest {
	
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
}
