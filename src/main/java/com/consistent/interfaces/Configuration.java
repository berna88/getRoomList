package com.consistent.interfaces;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "Posadas", scope  = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD (localization = "content/Language", id = "com.consistent.interfaces.Configuration", name = "Service RoomList")
public interface Configuration {
	
	@Meta.AD(required = false, description = "Get Folder Parent Name", deflt="0")
	public String getFolderParent();
	
	
}
