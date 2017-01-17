package com.qmdl.web.api.model.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userRequest")
public class UserRequest extends BaseRequest{
	
	@FormParam("phone")
	private String phone;
	
	@FormParam("password")
	private String password;
	
	/**
	 * 手机串
	 */
	@FormParam(value="deviceId")
	private String deviceId;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
