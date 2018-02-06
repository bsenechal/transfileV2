package com.transfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration {
	@Id
	@Column(name = "CONFIGURATION_ID", precision = 12, scale = 0)
	private Integer configId;
	
	@Column(name = "NAME_FILE", length=100)
	private String nameFile;
	
	@Column(name = "PROFILE", length=100)
    private String profile;
	
	@Column(name = "NAME_DEST", length=100)
    private String nameDest;
	
	@Column(name = "NAME_ZIP", length=100)
    private String nameZip;
	
//    private Boolean delete;
    
    @Column(name = "MULTIPLE", precision = 12, scale = 0)
    private Integer multiple;
    
    @Column(name = "OCCURENCE", precision = 12, scale = 0)
    private Integer occurence;
    
    @Column(name = "COMMENT", length=100)
    private String comment;
    
    @Column(name = "LIST_SERV", length=100)
    private String listServ;
    
    @Column(name = "RELEASES", length=100)
    private String release;

    //Getter/Setters
    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = nameDest;
    }

    public String getNameZip() {
        return nameZip;
    }

    public void setNameZip(String nameZip) {
        this.nameZip = nameZip;
    }
//
//    public Boolean getDelete() {
//        return delete;
//    }
//
//    public void setDelete(Boolean delete) {
//        this.delete = delete;
//    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getOccurence() {
        return occurence;
    }

    public void setOccurence(Integer occurence) {
        this.occurence = occurence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getListServ() {
        return listServ;
    }

    public void setListServ(String listServ) {
        this.listServ = listServ;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

	
}
