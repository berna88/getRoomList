package com.consistent.service.application;

import com.consistent.liferay.portal.Portal;
import com.consistent.singleton.SingletonRest;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;

/**
 * @author bernardohernadez
 */
@ApplicationPath("/service/psd/ecm")
@Component(immediate = true, 	service = Application.class
)
public class ServiceRoomListApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	/**
	 * @author bernardohernandez
	 * @param siteID
	 * @param language
	 * @param channel
	 * @param brandcode
	 * @param hotelcode
	 * @return devuelve el xml de habitaciones
	 */

	@GET
	@Path("/getRoomList")
	@Produces(MediaType.APPLICATION_XML)
	public String getRoomList(
		@QueryParam("siteID") String siteID,
		@QueryParam("language") String language,
		@QueryParam("channel") String channel,
		@QueryParam("brandcode") String brandcode,
		@QueryParam("hotelcode") String hotelcode) {
		
		//Asignando variables
		SingletonRest rest = SingletonRest.getInstance();
		rest.siteID = siteID;
		rest.language = language;
		rest.channel = channel;
		rest.brandcode = brandcode;
		rest.hotelcode = hotelcode;
		Portal.getFolderIdBrand();
		return "";
	}

}