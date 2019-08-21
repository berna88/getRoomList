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
	private String totalCapacity;
	private String childCapacity;
	private String adultCapacity;
	private String dimensions;
	private String inventory;
	private String numberOfBeds;
	private String standard;
	private String suite;
	private String HighLightValue;
	private String HighLightText;
	private String kingSizeBed;
	private String twinSizeBed;
	private String queenSizeBed;
	private String doubleBed;
	private String wifi;
	private String coffeeMaker;
	private String iron;
	private String ironBoard;
	private String tv;
	private String desk;
	private String minibar;
	private String livingRoom;
	private String bathtub;
	private String shower;
	private String featherPillow;
	private String syntheticPillow;
	private String securityBox;
	private String closet;
	private String iPodStation;
	private String airConditioner;
	private String heating;
	private String phone;
	private String bathrobe;
	private String hairdryer;
	private String slippers;
	private String other;
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
		totalCapacity = "";
		childCapacity = "";
		adultCapacity = "";
		dimensions = "";
		inventory = "";
		numberOfBeds = "";
		standard = "";
		suite = "";
		HighLightValue = "";
		HighLightText = "";
		kingSizeBed = "";
		twinSizeBed = "";
		queenSizeBed = "";
		doubleBed = "";
		wifi = "";
		coffeeMaker = "";
		iron = "";
		ironBoard = "";
		tv = "";
		desk = "";
		minibar = "";
		livingRoom = "";
		bathtub = "";
		shower = "";
		featherPillow="";
		syntheticPillow="";
		securityBox="";
		closet="";
		iPodStation="";
		airConditioner="";
		heating ="";
		phone ="";
		bathrobe = "";
		hairdryer = "";
		slippers = "";
		other = "";
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

	
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getHighLightValue() {
		return HighLightValue;
	}

	public void setHighLightValue(String highLightValue) {
		HighLightValue = highLightValue;
	}

	public String getHighLightText() {
		return HighLightText;
	}

	public void setHighLightText(String highLightText) {
		HighLightText = highLightText;
	}

	public String getKingSizeBed() {
		return kingSizeBed;
	}

	public void setKingSizeBed(String kingSizeBed) {
		this.kingSizeBed = kingSizeBed;
	}

	public String getTwinSizeBed() {
		return twinSizeBed;
	}

	public void setTwinSizeBed(String twinSizeBed) {
		this.twinSizeBed = twinSizeBed;
	}

	public String getQueenSizeBed() {
		return queenSizeBed;
	}

	public void setQueenSizeBed(String queenSizeBed) {
		this.queenSizeBed = queenSizeBed;
	}

	public String getDoubleBed() {
		return doubleBed;
	}

	public void setDoubleBed(String doubleBed) {
		this.doubleBed = doubleBed;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getCoffeeMaker() {
		return coffeeMaker;
	}

	public void setCoffeeMaker(String coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	public String getIron() {
		return iron;
	}

	public void setIron(String iron) {
		this.iron = iron;
	}

	public String getIronBoard() {
		return ironBoard;
	}

	public void setIronBoard(String ironBoard) {
		this.ironBoard = ironBoard;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public String getMinibar() {
		return minibar;
	}

	public void setMinibar(String minibar) {
		this.minibar = minibar;
	}

	public String getLivingRoom() {
		return livingRoom;
	}

	public void setLivingRoom(String livingRoom) {
		this.livingRoom = livingRoom;
	}

	public String getBathtub() {
		return bathtub;
	}

	public void setBathtub(String bathtub) {
		this.bathtub = bathtub;
	}

	public String getShower() {
		return shower;
	}

	public void setShower(String shower) {
		this.shower = shower;
	}

	public String getFeatherPillow() {
		return featherPillow;
	}

	public void setFeatherPillow(String featherPillow) {
		this.featherPillow = featherPillow;
	}

	public String getSyntheticPillow() {
		return syntheticPillow;
	}

	public void setSyntheticPillow(String syntheticPillow) {
		this.syntheticPillow = syntheticPillow;
	}

	public String getSecurityBox() {
		return securityBox;
	}

	public void setSecurityBox(String securityBox) {
		this.securityBox = securityBox;
	}

	public String getCloset() {
		return closet;
	}

	public void setCloset(String closet) {
		this.closet = closet;
	}

	public String getiPodStation() {
		return iPodStation;
	}

	public void setiPodStation(String iPodStation) {
		this.iPodStation = iPodStation;
	}

	public String getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}

	public String getHeating() {
		return heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBathrobe() {
		return bathrobe;
	}

	public void setBathrobe(String bathrobe) {
		this.bathrobe = bathrobe;
	}

	public String getHairdryer() {
		return hairdryer;
	}

	public void setHairdryer(String hairdryer) {
		this.hairdryer = hairdryer;
	}

	public String getSlippers() {
		return slippers;
	}

	public void setSlippers(String slippers) {
		this.slippers = slippers;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(String totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public String getChildCapacity() {
		return childCapacity;
	}

	public void setChildCapacity(String childCapacity) {
		this.childCapacity = childCapacity;
	}

	public String getAdultCapacity() {
		return adultCapacity;
	}

	public void setAdultCapacity(String adultCapacity) {
		this.adultCapacity = adultCapacity;
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
				xMLStreamWriter.writeDTD(shortDescription);
			xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeStartElement("description");
				xMLStreamWriter.writeDTD(description);
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
	         //Groups
	         xMLStreamWriter.writeStartElement("groups");
	         	xMLStreamWriter.writeStartElement("group");
	         		xMLStreamWriter.writeStartElement("guid");
	         			xMLStreamWriter.writeCharacters("");
	         		xMLStreamWriter.writeEndElement();
	         		xMLStreamWriter.writeStartElement("name");
         				xMLStreamWriter.writeCharacters("");
         			xMLStreamWriter.writeEndElement();
         			xMLStreamWriter.writeStartElement("title");
     					xMLStreamWriter.writeCharacters("");
     				xMLStreamWriter.writeEndElement();
     				xMLStreamWriter.writeStartElement("language");
 						xMLStreamWriter.writeCharacters("");
 					xMLStreamWriter.writeEndElement();
 					xMLStreamWriter.writeStartElement("keyword");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("shortDescription");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("description");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("order");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("channel");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("available");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("medialinks");
						xMLStreamWriter.writeCharacters("");
					xMLStreamWriter.writeEndElement();
	         	xMLStreamWriter.writeEndElement();
			 xMLStreamWriter.writeEndElement();
	         //Fin de groups
			
			
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
		room.totalCapacity = document.valueOf("//dynamic-element[@name='totalCapacityRoom']/dynamic-content/text()").replace("\"", "").replace("[", "").replace("]", "");
		room.childCapacity = document.valueOf("//dynamic-element[@name='childCapacityRoom']/dynamic-content/text()");
		room.adultCapacity = document.valueOf("//dynamic-element[@name='adultCapacityRoom']/dynamic-content/text()");
		room.dimensions = document.valueOf("//dynamic-element[@name='dimensionsRoom']/dynamic-content/text()");
		room.inventory = document.valueOf("//dynamic-element[@name='inventaryRoom']/dynamic-content/text()");
		room.numberOfBeds = document.valueOf("//dynamic-element[@name='Dimensiones4gg5']/dynamic-content/text()");
		room.standard = document.valueOf("//dynamic-element[@name='standardRoom']/dynamic-content/text()");
		room.suite = document.valueOf("//dynamic-element[@name='suiteRoom']/dynamic-content/text()");
		room.HighLightValue = document.valueOf("//dynamic-element[@name='highLightValueRoom']/dynamic-content/text()");
		room.HighLightText = document.valueOf("//dynamic-element[@name='highLightTextRoom']/dynamic-content/text()");
		room.kingSizeBed = document.valueOf("//dynamic-element[@name='Wifi5ogh']/dynamic-content/text()");
		room.twinSizeBed = document.valueOf("//dynamic-element[@name='Wifiru3r']/dynamic-content/text()");
		room.queenSizeBed = document.valueOf("//dynamic-element[@name='Wifi58wf']/dynamic-content/text()");
		room.doubleBed = document.valueOf("//dynamic-element[@name='CamaQueenSize2nci']/dynamic-content/text()");
		room.wifi = document.valueOf("//dynamic-element[@name='wifiRoom']/dynamic-content/text()");
		room.coffeeMaker = document.valueOf("//dynamic-element[@name='coffeeMarkerRoom']/dynamic-content/text()");
		room.iron = document.valueOf("//dynamic-element[@name='ironRoom']/dynamic-content/text()");
		room.ironBoard = document.valueOf("//dynamic-element[@name='ironBoardRoom']/dynamic-content/text()");
		room.tv = document.valueOf("//dynamic-element[@name='tvRoom']/dynamic-content/text()");
		room.desk = document.valueOf("//dynamic-element[@name='deskRoom']/dynamic-content/text()");
		room.minibar = document.valueOf("//dynamic-element[@name='minibarRoom']/dynamic-content/text()");
		room.livingRoom = document.valueOf("//dynamic-element[@name='livingRoom']/dynamic-content/text()");
		room.bathtub = document.valueOf("//dynamic-element[@name='bathtubRoom']/dynamic-content/text()");
		room.shower = document.valueOf("//dynamic-element[@name='showerRoom']/dynamic-content/text()");
		room.featherPillow = document.valueOf("//dynamic-element[@name='AlmohadaDePlumas']/dynamic-content/text()");
		room.syntheticPillow = document.valueOf("//dynamic-element[@name='AlmohadaDePlumas9wgm']/dynamic-content/text()");
		room.securityBox = document.valueOf("//dynamic-element[@name='securityBoxRoom']/dynamic-content/text()");
		room.closet = document.valueOf("//dynamic-element[@name='closetRoom']/dynamic-content/text()");
		room.iPodStation = document.valueOf("//dynamic-element[@name='ipodStationRoom']/dynamic-content/text()");
		room.airConditioner = document.valueOf("//dynamic-element[@name='airConditionerRoom']/dynamic-content/text()");
		room.heating = document.valueOf("//dynamic-element[@name='heatingRoom']/dynamic-content/text()");
		room.phone = document.valueOf("//dynamic-element[@name='phoneRoom']/dynamic-content/text()");
		room.bathrobe = document.valueOf("//dynamic-element[@name='bathrobeRoom']/dynamic-content/text()");
		room.hairdryer = document.valueOf("//dynamic-element[@name='dryerRoom']/dynamic-content/text()");
		room.slippers = document.valueOf("//dynamic-element[@name='slippersRoom']/dynamic-content/text()");
		room.other = document.valueOf("//dynamic-element[@name='otherRoom']/dynamic-content/text()");
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
