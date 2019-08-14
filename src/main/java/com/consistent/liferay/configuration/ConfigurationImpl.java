package com.consistent.liferay.configuration;

import com.consistent.interfaces.Configuration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

@Component(
		immediate=true,
		configurationPid = "com.consistent.interfaces.Configuration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		property= {"jaxrs.application=true"}
		)

public class ConfigurationImpl{
	
	private static final Log log = LogFactoryUtil.getLog(ConfigurationImpl.class);
	public static String parentFolder = "";
	public static Long roomStructureId = null;
	
	/**
	 * @author bernardohernandez
	 * @param properties
	 */
	@Activate
	@Modified
	private void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(Configuration.class, properties);
		try {
			if (configuration != null) {
				if (!configuration.getFolderParent().isEmpty()) {
					log.info("Nombre de carpeta Hotel: " + configuration.getFolderParent());
					parentFolder = configuration.getFolderParent();
				} 
				
				if (configuration.getRoomStructureId() == 0) {
					log.info("No se colocado el identificador de la estructura Habitación");
				}else {
					log.info("EstrutureId Room: " + configuration.getRoomStructureId());
					roomStructureId = configuration.getRoomStructureId();
				}
			} else {
				log.info("The sample DXP REST config object is not yet initialized");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error en el activate Metodo Active" + e);
		}
	}
	
	private Configuration configuration;
}
