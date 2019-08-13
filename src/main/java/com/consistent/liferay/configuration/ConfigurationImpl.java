package com.consistent.liferay.configuration;

import com.consistent.interfaces.Configuration;
import com.consistent.interfaces.Constants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

@Component(
		immediate=true,
		configurationPid = "com.consistent.facility.interfaces.Configuration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		property= {"jaxrs.application=true"}
		)

public class ConfigurationImpl implements Constants{
	
	private static final Log log = LogFactoryUtil.getLog(ConfigurationImpl.class);
	
	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		configuration = ConfigurableUtil.createConfigurable(Configuration.class, properties);
		try {
			if(configuration!=null) {
				if(!configuration.getFolderParent().isEmpty()) {
					
				}else {
					
				}
			}else {
				log.info("The sample DXP REST config object is not yet initialized");
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error en el activate Metodo Active"+e);
		}
	}
	
	private Configuration configuration;
}
