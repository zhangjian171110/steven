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
@TableName("carousel_info")
public class CarouselInfo implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.UUID)
	protected String id;

	/** 主题 */
	protected String Title;

	/** 内容地址 */
	protected String ContentUrl;

	/** 图片地址 */
	protected String ImageUrl;

	/**  */
	protected String type;

	/** 创建时间 */
	protected Date CreateTime;

	/** 更新时间 */
	protected Date UpdateTime;

	/** 删除标志，0表示否，1表示已删除 */
	protected String deleteFlag;

	protected String description;
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getContentUrl() {
		return this.ContentUrl;
	}

	public void setContentUrl(String ContentUrl) {
		this.ContentUrl = ContentUrl;
	}

	public String getImageUrl() {
		return this.ImageUrl;
	}

	public void setImageUrl(String ImageUrl) {
		this.ImageUrl = ImageUrl;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return this.CreateTime;
	}

	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}

	public Date getUpdateTime() {
		return this.UpdateTime;
	}

	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
