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
@XmlRootElement(name = "isUpdateRequest")
public class IsUpdateRequest extends BaseRequest{
	
	/**
	 * 
	 */
	@FormParam("version")
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
