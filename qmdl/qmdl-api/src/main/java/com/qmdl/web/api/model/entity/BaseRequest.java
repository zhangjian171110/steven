package com.qmdl.web.api.model.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * {接口公共参数}
 *  
 *  @author Steven Zhang
 *  @lastModified       
 *  @history           
 */
@XmlRootElement
public class BaseRequest {
	
	/**
	 * 手机类型
	 */
	@FormParam(value="phoneType")
	private String phoneType;
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
}




