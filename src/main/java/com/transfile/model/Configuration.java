package com.transfile.model;

public class Configuration {
	private Integer configId;
	private String nameFile;
    private String profile;
    private String nameDest;
    private String nameZip;
    private Boolean delete;
    private Integer multiple;
    private Integer occurence;
    private String comment;
    private String listServ;
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

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

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
