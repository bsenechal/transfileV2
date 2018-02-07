package com.transfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration {
	@Id
	@Column(name = "CONFIGURATION_ID", precision = 11, scale = 0)
	private Integer configurationId;

	@Column(name = "NAME_FILE", length = 25)
	private String nameFile;

	@Column(name = "PROFILE", length = 25)
	private String profile;

	@Column(name = "NAME_DEST", length = 50)
	private String nameDest;

	@Column(name = "NAME_ZIP", length = 50)
	private String nameZip;

	@Column(name = "DELETE_FLAG", columnDefinition = "BOOLEAN")
	private Boolean deleteFlag;

	@Column(name = "MULTIPLE", precision = 11, scale = 0)
	private Integer multiple;

	@Column(name = "OCCURENCE", precision = 11, scale = 0)
	private Integer occurence;

	@Column(name = "COMMENT", length = 200)
	private String comment;

	@Column(name = "LIST_SERV", length = 200)
	private String listServ;

	@Column(name = "RELEASES", length = 25)
	private String releases;

	/**
	 * @return the configurationId
	 */
	public Integer getConfigurationId() {
		return configurationId;
	}

	/**
	 * @param configurationId
	 *            the configurationId to set
	 */
	public void setConfigurationId(Integer configurationId) {
		this.configurationId = configurationId;
	}

	/**
	 * @return the nameFile
	 */
	public String getNameFile() {
		return nameFile;
	}

	/**
	 * @param nameFile
	 *            the nameFile to set
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the nameDest
	 */
	public String getNameDest() {
		return nameDest;
	}

	/**
	 * @param nameDest
	 *            the nameDest to set
	 */
	public void setNameDest(String nameDest) {
		this.nameDest = nameDest;
	}

	/**
	 * @return the nameZip
	 */
	public String getNameZip() {
		return nameZip;
	}

	/**
	 * @param nameZip
	 *            the nameZip to set
	 */
	public void setNameZip(String nameZip) {
		this.nameZip = nameZip;
	}

	/**
	 * @return the deleteFlag
	 */
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag
	 *            the deleteFlag to set
	 */
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the multiple
	 */
	public Integer getMultiple() {
		return multiple;
	}

	/**
	 * @param multiple
	 *            the multiple to set
	 */
	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	/**
	 * @return the occurence
	 */
	public Integer getOccurence() {
		return occurence;
	}

	/**
	 * @param occurence
	 *            the occurence to set
	 */
	public void setOccurence(Integer occurence) {
		this.occurence = occurence;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the listServ
	 */
	public String getListServ() {
		return listServ;
	}

	/**
	 * @param listServ
	 *            the listServ to set
	 */
	public void setListServ(String listServ) {
		this.listServ = listServ;
	}

	/**
	 * @return the releases
	 */
	public String getReleases() {
		return releases;
	}

	/**
	 * @param releases
	 *            the releases to set
	 */
	public void setReleases(String releases) {
		this.releases = releases;
	}
}
