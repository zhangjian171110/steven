package com.qmdl.web.api.model.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {失信惩戒对象入参Bean}
 * 
 * @author Steven Zhang
 * @lastModified
 * @history
 */
@XmlRootElement(name = "carouselInfoRequest")
public class CarouselInfoRequest extends BaseRequest{
	
	/**
	 * 
	 */
	@FormParam("type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
