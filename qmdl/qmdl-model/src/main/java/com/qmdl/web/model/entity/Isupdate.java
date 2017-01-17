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
@TableName("isupdate")
public class Isupdate implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.UUID,value="ID")
	protected String id;

	/** 更新类型：0：不更新，1选择更新，2强制更新 */
	protected String IsUpdate;

	/** 更新文本 */
	protected String UpdateTxt;

	/** 下载Url */
	protected String UpdateUrl;

	/** app版本号 */
	protected String Version;

	/** 更新版本号 */
	protected String VersionName;

	/** 来源：0：安卓，1：Ios */
	protected String AppType;

	/** 是否发布：0：待审核1：发布 */
	protected String IsDeploy;

	/** 创建时间 */
	protected Date CreateTime;

	/** 创建Userid */
	protected String CreateUserId;

	/** 创建人 */
	protected String CreateName;

	/** 更新时间 */
	protected Date UpdateTime;

	/** 更新Userid */
	protected String UpdateUserId;

	/** 更新人 */
	protected String UpdateName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsUpdate() {
		return this.IsUpdate;
	}

	public void setIsUpdate(String IsUpdate) {
		this.IsUpdate = IsUpdate;
	}

	public String getUpdateTxt() {
		return this.UpdateTxt;
	}

	public void setUpdateTxt(String UpdateTxt) {
		this.UpdateTxt = UpdateTxt;
	}

	public String getUpdateUrl() {
		return this.UpdateUrl;
	}

	public void setUpdateUrl(String UpdateUrl) {
		this.UpdateUrl = UpdateUrl;
	}

	public String getVersion() {
		return this.Version;
	}

	public void setVersion(String Version) {
		this.Version = Version;
	}

	public String getVersionName() {
		return this.VersionName;
	}

	public void setVersionName(String VersionName) {
		this.VersionName = VersionName;
	}

	public String getAppType() {
		return this.AppType;
	}

	public void setAppType(String AppType) {
		this.AppType = AppType;
	}

	public String getIsDeploy() {
		return this.IsDeploy;
	}

	public void setIsDeploy(String IsDeploy) {
		this.IsDeploy = IsDeploy;
	}

	public Date getCreateTime() {
		return this.CreateTime;
	}

	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}

	public String getCreateUserId() {
		return this.CreateUserId;
	}

	public void setCreateUserId(String CreateUserId) {
		this.CreateUserId = CreateUserId;
	}

	public String getCreateName() {
		return this.CreateName;
	}

	public void setCreateName(String CreateName) {
		this.CreateName = CreateName;
	}

	public Date getUpdateTime() {
		return this.UpdateTime;
	}

	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}

	public String getUpdateUserId() {
		return this.UpdateUserId;
	}

	public void setUpdateUserId(String UpdateUserId) {
		this.UpdateUserId = UpdateUserId;
	}

	public String getUpdateName() {
		return this.UpdateName;
	}

	public void setUpdateName(String UpdateName) {
		this.UpdateName = UpdateName;
	}

}
