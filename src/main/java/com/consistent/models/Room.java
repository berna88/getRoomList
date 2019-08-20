package com.consistent.models;

import com.consistent.interfaces.Constants;
import com.consistent.interfaces.XML;
import com.consistent.liferay.portal.Portal;
import com.consistent.singleton.SingletonRest;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.impl.JournalArticleImpl;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Room extends Portal implements XML, Constants{
	
	private static final Log log = LogFactoryUtil.getLog(Room.class);
	static final SingletonRest rest = SingletonRest.getInstance();
	
	private String guid;
	private String code;
	private String name;
	private String title;
	private String language;
	private String keyword;
	private String shortDescription;
	private String description;
	private String order = ORDER;
	private String channel = CHANNEL;
	private String tags;
	private List<String> medialinks;
	
	public Room() {
		tags = "";
		guid = "";
		code = "";
		name = "";
		title = "";
		language = "";
		keyword = "";
		shortDescription = "";
		description = "";
		order = ORDER;
		channel = CHANNEL;
		medialinks = new ArrayList<String>(); 
	}
	
	public Room(String guid, String code, String name, String title, String language, String keyword,
			String shortDescription, String description, String order, String channel, List<String> medialinks) {
		super();
		this.guid = guid;
		this.code = code;
		this.name = name;
		this.title = title;
		this.language = language;
		this.keyword = keyword;
		this.shortDescription = shortDescription;
		this.description = description;
		this.order = order;
		this.channel = channel;
		this.medialinks = medialinks;
	}



	public String getGuid() {
		return guid;
	}




	public void setGuid(String guid) {
		this.guid = guid;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public String getKeyword() {
		return keyword;
	}




	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}




	public String getShortDescription() {
		return shortDescription;
	}




	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getOrder() {
		return order;
	}




	public void setOrder(String order) {
		this.order = order;
	}




	public String getChannel() {
		return channel;
	}




	public void setChannel(String channel) {
		this.channel = channel;
	}




	public List<String> getMedialinks() {
		return medialinks;
	}




	public void setMedialinks(List<String> medialinks) {
		this.medialinks = medialinks;
	}




	public static Log getLog() {
		return log;
	}




	@Override
	public String getMapping() throws XMLStreamException, IOException {
		// TODO Auto-generated method stub
		StringWriter stringWriter = new StringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xMLStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xMLStreamWriter.writeStartElement("content");
			xMLStreamWriter.writeStartElement("guid");
				xMLStreamWriter.writeCharacters(guid);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("code");
				xMLStreamWriter.writeCharacters(code);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("name");
				xMLStreamWriter.writeCharacters(name);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("title");
				xMLStreamWriter.writeCharacters(title);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("language");
				xMLStreamWriter.writeCharacters(rest.language);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("keyword");
				xMLStreamWriter.writeCharacters(keyword);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("shortDescription");
				xMLStreamWriter.writeCharacters(shortDescription);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("description");
				xMLStreamWriter.writeCharacters(description);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("order");
				xMLStreamWriter.writeCharacters(ORDER);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("channel");
				xMLStreamWriter.writeCharacters(CHANNEL);
			xMLStreamWriter.writeEndElement();
			
			//mediaLink section
			/*mediaLink section*/
	         JSONArray ArrayMediaLinks = JSONFactoryUtil.createJSONArray();
	         List<String> MeliaLinkList = getMedialinks();
				for (String mediaLinkItem : MeliaLinkList) {
					JSONObject myObject;
					try {
						
						myObject = JSONFactoryUtil.createJSONObject(mediaLinkItem);
						ArrayMediaLinks.put(myObject);
					} catch (JSONException e) {
						log.error("Error converter json"+e);
					}
					
				}
				xMLStreamWriter.writeStartElement("medialinks");		   
		         xMLStreamWriter.writeStartElement("medialink");
		         
				   xMLStreamWriter.writeStartElement("keyword");
				   	xMLStreamWriter.writeCharacters(tags);
				   xMLStreamWriter.writeEndElement();
				         for (int i = 0; i < ArrayMediaLinks.length(); i++) {
								JSONObject jsonobject = ArrayMediaLinks.getJSONObject(i);
							    String link = jsonobject.getString("link");
							    String type_image = jsonobject.getString("type_image");
								xMLStreamWriter.writeStartElement("multimedia");
					            xMLStreamWriter.writeAttribute("type",type_image);
						        xMLStreamWriter.writeStartElement("url");
						        xMLStreamWriter.writeCharacters(link);
						        xMLStreamWriter.writeEndElement();
					            xMLStreamWriter.writeEndElement();
							}
				         xMLStreamWriter.writeStartElement("thumbnail");
				         xMLStreamWriter.writeEndElement();
				         xMLStreamWriter.writeStartElement("type");
				         xMLStreamWriter.writeEndElement();
			      xMLStreamWriter.writeEndElement();
	         xMLStreamWriter.writeEndElement();
	          //mediaLink section
			
			
		xMLStreamWriter.writeEndElement();
		
		xMLStreamWriter.flush();
		xMLStreamWriter.close();
		String result = stringWriter.getBuffer().toString();
		stringWriter.close(); 
		return result;
	}
	
	private HashSet<String> getRoomListAll(){
		HashSet<String> articleRecovery = new HashSet<String>();
		try {
			for(JournalArticleImpl article: validBrandOrHotelCode()) {
				if(!article.isInTrash()){// Validando si no estan en papeleria de reciclaje
					if(JournalArticleLocalServiceUtil.isLatestVersion(rest.getSiteIDLong(), article.getArticleId(), article.getVersion())) {
						articleRecovery.add(parseRooms(article));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error en metodo getRoomListAll");
			e.getStackTrace();
		}
		return articleRecovery;
	}
	
	private String parseRooms(JournalArticle article) throws DocumentException, XMLStreamException, IOException {
		final Room room = new Room();
		String locale = rest.getLanguaje();
		room.guid = article.getArticleId();
		room.title = article.getTitle(locale);
		Document document = null;
		document = SAXReaderUtil.read(article.getContentByLocale(locale));
		room.code = document.valueOf("//dynamic-element[@name='codeRoom']/dynamic-content/text()");
		room.name = document.valueOf("//dynamic-element[@name='nameRoom']/dynamic-content/text()");
		room.keyword = document.valueOf("//dynamic-element[@name='keywordsRoom']/dynamic-content/text()");
		room.description = document.valueOf("//dynamic-element[@name='descriptionRoom']/dynamic-content/text()");
		room.shortDescription = document.valueOf("//dynamic-element[@name='shortDescriptionRoom']/dynamic-content/text()");
		final List<AssetTag> tags = AssetTagLocalServiceUtil.getTags(JournalArticle.class.getName(), article.getResourcePrimKey());
		String tag = "";
		if(!tags.isEmpty()) {
			for(AssetTag categoryRecovery : tags) {
				tag = tag.concat(categoryRecovery.getName());
			}
		}
		room.tags = tag;
		//medialinks
		List<Node> mediaNodes = document.selectNodes("//dynamic-element[@name='mediaLinksRoom']/dynamic-element");
		List<String> mediaArray = new ArrayList<String>();
		for (Node mediaNode : mediaNodes) {
			String pie = mediaNode.valueOf("dynamic-element[@name='footer']/dynamic-content/text()");
			String link = mediaNode.valueOf("dynamic-content/text()");
			String type_image = mediaNode.valueOf("dynamic-element[@name='typeRoom']/dynamic-content/text()");
			if(!link.trim().equals("")){
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("link", link);
				object.put("pie", pie);
				object.put("type_image", type_image);
				mediaArray.add(object.toJSONString());
			}
		}
		room.medialinks = sanitizeArray(mediaArray);
		return room.getMapping();
	}
	private List<String> sanitizeArray(List<String> arraySan){
    	if(arraySan.size()>0){
	    	while(arraySan.size()<1){
				JSONObject object=JSONFactoryUtil.createJSONObject();
				arraySan.add(object.toJSONString());				
			}
    	}
    	
    	return arraySan;    	
    }

	@Override
	public String getContent() throws XMLStreamException, IOException {
		StringWriter stringWriter = new StringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xMLStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
		xMLStreamWriter.writeStartDocument();
			xMLStreamWriter.writeStartElement("contents");
				for(String rooms: getRoomListAll()) {
					xMLStreamWriter.writeDTD(rooms);
				}
			xMLStreamWriter.writeEndElement();
		xMLStreamWriter.writeEndDocument();
		xMLStreamWriter.flush();
		xMLStreamWriter.close();
		String result = stringWriter.getBuffer().toString();
		//result = result.replace("&lt;", "<").replace("&gt;", ">");
		stringWriter.close(); 
		
		return result;
	}
	
	
	
}
