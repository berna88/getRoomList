package com.consistent.interfaces;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "Posadas", scope  = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD (localization = "content/Language", id = "com.consistent.interfaces.Configuration", name = "Service RoomList")
public interface Configuration {
	
	/**
	 * @author bernardohernadez
	 * @return El nombre de la carpeta padre
	 */
	@Meta.AD(required = false, description = "Get Folder Parent Name", deflt="0")
	public String getFolderParent();
	
	@Meta.AD(required = false, description = "Get Room StructureId", deflt="0")
	public Long getRoomStructureId();
}
