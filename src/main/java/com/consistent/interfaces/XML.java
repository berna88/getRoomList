package com.consistent.interfaces;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

public interface XML {
	
	public String getMapping() throws XMLStreamException, IOException;
	
	public String getContent() throws XMLStreamException, IOException;
}
