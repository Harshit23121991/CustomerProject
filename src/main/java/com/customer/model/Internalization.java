package com.customer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pavan
 *
 */
@Entity
@Table(name = "i18n")
public class Internalization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 324234234321L;

	/**
	 * 
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "i18n_id", unique = true, nullable = false)
	private Long i18nId;
	@Column(name = "label_code")
	private String labelCode;
	@Column(name = "screen_name")
	private String screenName;
	@Column(name = "english")
	private String english;
	@Column(name ="german")
	private String german;
	@Column(name ="french")
	private String french;
	@Column(name ="spanish")
	private String spanish;
	@Column(name= "info")
	private String info;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name= "is_delete")
	private Long isDelete;
	@Column(name= "is_active")
	private Long isActive;
	
	public Long getI18nId() {
		return i18nId;
	}
	public void setI18nId(Long i18nId) {
		this.i18nId = i18nId;
	}
	public String getLabelCode() {
		return labelCode;
	}
	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}
	
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getGerman() {
		return german;
	}
	public void setGerman(String german) {
		this.german = german;
	}
	public String getFrench() {
		return french;
	}
	public void setFrench(String french) {
		this.french = french;
	}
	public String getSpanish() {
		return spanish;
	}
	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}
	public Long getIsActive() {
		return isActive;
	}
	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}
}
