package com.qmdl.web.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.mybatis.plus.mybatisplus.annotations.IdType;
import org.mybatis.plus.mybatisplus.annotations.TableField;
import org.mybatis.plus.mybatisplus.annotations.TableId;
import org.mybatis.plus.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("user")
public class User implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/** 主键 */
	@TableId(type=IdType.UUID,value = "ID")
	protected String id;

	/** 创建时间 */
	@TableField(value = "gmt_create")
	protected Date gmtCreate;

	/** 修改时间 */
	@TableField(value = "gmt_modified")
	protected Date gmtModified;

	/** 手机号码 */
	protected String telephone;

	/** 密码 */
	protected String password;

	/** 昵称 */
	protected String nickname;

	/** 简介 */
	protected String introduction;

	/** 头像地址 */
	@TableField(value = "profile_address")
	protected String profileAddress;

	/** 角色 */
	protected String role;

	/** 发货人手机号码 */
	@TableField(value = "consigner_telephone")
	protected String consignerTelephone;

	/** 发货人地址 */
	@TableField(value = "consigner_address")
	protected String consignerAddress;
	
	/**
	 * 手机类型
	 */
	@TableField(value = "phoneType")
	protected String phoneType;
	
	/**
	 * 最后登录时间
	 */
	@TableField(value = "loginTime")
	protected Date loginTime;
	
	/**
	 * 手机推送消息
	 */
	@TableField(value = "deviceId")
	protected String deviceId;

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return this.gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getProfileAddress() {
		return this.profileAddress;
	}

	public void setProfileAddress(String profileAddress) {
		this.profileAddress = profileAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getConsignerTelephone() {
		return this.consignerTelephone;
	}

	public void setConsignerTelephone(String consignerTelephone) {
		this.consignerTelephone = consignerTelephone;
	}

	public String getConsignerAddress() {
		return this.consignerAddress;
	}

	public void setConsignerAddress(String consignerAddress) {
		this.consignerAddress = consignerAddress;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
