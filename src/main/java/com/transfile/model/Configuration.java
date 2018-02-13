package com.transfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration {
    @Id
    @Column(name = "CONFIG_ID", precision = 11, scale = 0)
    private Integer configId;
    
    @Column(name = "PROFILE", length = 255)
    private String profile;
    
    @Column(name = "NAME_FILE", length = 255)
    private String nameFile;

    @Column(name = "NAME_ZIP", length = 255)
    private String nameZip;
    
    @Column(name = "DELETE_FLAG", columnDefinition = "BOOLEAN")
    private Boolean deleteFlag;
    
    @Column(name = "MULTIPLE", precision = 11, scale = 0)
    private Integer multiple;
    
    @Column(name = "OCCURENCE", precision = 11, scale = 0)
    private Integer occurence;
    
    @Column(name = "COMMENTS", length = 255)
    private String comments;
    
    @Column(name = "HOST_LIST", length = 255)
    private String hostList;
    
    @Column(name = "RELEASE_NUMBER", length = 255)
    private String releaseNumber;
    
    @Column(name = "FORCED_ZIP_NAME", length = 255)
    private String forcedZipName;
    
    @Column(name = "FORCED_FILE_NAME", length = 255)
    private String forcedFileName;
    
    @Column(name = "EXTENTION", length = 50)
    private String extention;
    
    @Column(name = "DATE_FORMAT", length = 250)
    private String dateFormat;
    
    @Column(name = "PROJECT_ID", precision = 11, scale = 0)
    private String projectId;
    
    @Column(name = "LOG_TYPE", length = 255)
    private String logType;
    
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    /**
     * @return the configId
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * @param configId the configId to set
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @return the nameFile
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * @param nameFile the nameFile to set
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * @return the nameZip
     */
    public String getNameZip() {
        return nameZip;
    }

    /**
     * @param nameZip the nameZip to set
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
     * @param deleteFlag the deleteFlag to set
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
     * @param multiple the multiple to set
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
     * @param occurence the occurence to set
     */
    public void setOccurence(Integer occurence) {
        this.occurence = occurence;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the hostList
     */
    public String getHostList() {
        return hostList;
    }

    /**
     * @param hostList the hostList to set
     */
    public void setHostList(String hostList) {
        this.hostList = hostList;
    }

    /**
     * @return the releaseNumber
     */
    public String getReleaseNumber() {
        return releaseNumber;
    }

    /**
     * @param releaseNumber the releaseNumber to set
     */
    public void setReleaseNumber(String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    /**
     * @return the forcedZipName
     */
    public String getForcedZipName() {
        return forcedZipName;
    }

    /**
     * @param forcedZipName the forcedZipName to set
     */
    public void setForcedZipName(String forcedZipName) {
        this.forcedZipName = forcedZipName;
    }

    /**
     * @return the forcedFileName
     */
    public String getForcedFileName() {
        return forcedFileName;
    }

    /**
     * @param forcedFileName the forcedFileName to set
     */
    public void setForcedFileName(String forcedFileName) {
        this.forcedFileName = forcedFileName;
    }

    /**
     * @return the extention
     */
    public String getExtention() {
        return extention;
    }

    /**
     * @param extention the extention to set
     */
    public void setExtention(String extention) {
        this.extention = extention;
    }

    /**
     * @return the dateFormat
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the logType
     */
    public String getLogType() {
        return logType;
    }

    /**
     * @param logType the logType to set
     */
    public void setLogType(String logType) {
        this.logType = logType;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
