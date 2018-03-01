/*
 *
 */
package com.transfile.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.transfile.client.Client;

/**
 * Configuration bean
 *
 */
@Entity
@Table(name = "CONFIGURATION")
public class Configuration {
    @Id
    @Column(name = "CONFIG_ID", precision = 11, scale = 0)
    private Integer configId;

    @Column(name = "LOG_TYPE", length = 255)
    private String logType;

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
    
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;
    
    /**
     *
     */
    public Configuration() {
        super();
    }
    
    /**
     * @param configId
     * @param profile
     * @param nameFile
     * @param nameZip
     * @param deleteFlag
     * @param multiple
     * @param occurence
     * @param comments
     * @param hostList
     * @param releaseNumber
     * @param forcedZipName
     * @param forcedFileName
     * @param extention
     * @param dateFormat
     * @param projectId
     * @param logType
     */
    public Configuration(final Integer configId, final String logType, final String profile, final String nameFile, final String nameZip,
            final Boolean deleteFlag, final Integer multiple, final Integer occurence, final String comments, final String hostList,
            final String releaseNumber, final String forcedZipName, final String forcedFileName, final String extention, final String dateFormat,
            final String projectId) {
        super();
        this.configId = configId;
        this.logType = logType;
        this.profile = profile;
        this.nameFile = nameFile;
        this.nameZip = nameZip;
        this.deleteFlag = deleteFlag;
        this.multiple = multiple;
        this.occurence = occurence;
        this.comments = comments;
        this.hostList = hostList;
        this.releaseNumber = releaseNumber;
        this.forcedZipName = forcedZipName;
        this.forcedFileName = forcedFileName;
        this.extention = extention;
        this.dateFormat = dateFormat;
        this.projectId = projectId;
    }
    
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }
    
    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * @return the configId
     */
    public Integer getConfigId() {
        return configId;
    }
    
    /**
     * @return the dateFormat
     */
    public String getDateFormat() {
        return dateFormat;
    }
    
    /**
     * @return the deleteFlag
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }
    
    /**
     * @return the extention
     */
    public String getExtention() {
        return extention;
    }
    
    /**
     * @return the forcedFileName
     */
    public String getForcedFileName() {
        return forcedFileName;
    }
    
    /**
     * @return the forcedZipName
     */
    public String getForcedZipName() {
        return forcedZipName;
    }
    
    /**
     * @return the hostList
     */
    public String getHostList() {
        return hostList;
    }
    
    /**
     * @return the logType
     */
    public String getLogType() {
        return logType;
    }
    
    /**
     * @return the multiple
     */
    public Integer getMultiple() {
        return multiple;
    }
    
    /**
     * @return the nameFile
     */
    public String getNameFile() {
        return nameFile;
    }
    
    /**
     * @return the nameZip
     */
    public String getNameZip() {
        return nameZip;
    }
    
    /**
     * @return the occurence
     */
    public Integer getOccurence() {
        return occurence;
    }
    
    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }
    
    /**
     * @return the projectId
     */
    public String getProjectId() {
        return projectId;
    }
    
    /**
     * @return the releaseNumber
     */
    public String getReleaseNumber() {
        return releaseNumber;
    }
    
    /**
     * @param client
     *            the client to set
     */
    public void setClient(final Client client) {
        this.client = client;
    }
    
    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(final String comments) {
        this.comments = comments;
    }
    
    /**
     * @param configId
     *            the configId to set
     */
    public void setConfigId(final Integer configId) {
        this.configId = configId;
    }
    
    /**
     * @param dateFormat
     *            the dateFormat to set
     */
    public void setDateFormat(final String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    /**
     * @param deleteFlag
     *            the deleteFlag to set
     */
    public void setDeleteFlag(final Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    /**
     * @param extention
     *            the extention to set
     */
    public void setExtention(final String extention) {
        this.extention = extention;
    }
    
    /**
     * @param forcedFileName
     *            the forcedFileName to set
     */
    public void setForcedFileName(final String forcedFileName) {
        this.forcedFileName = forcedFileName;
    }
    
    /**
     * @param forcedZipName
     *            the forcedZipName to set
     */
    public void setForcedZipName(final String forcedZipName) {
        this.forcedZipName = forcedZipName;
    }
    
    /**
     * @param hostList
     *            the hostList to set
     */
    public void setHostList(final String hostList) {
        this.hostList = hostList;
    }
    
    /**
     * @param logType
     *            the logType to set
     */
    public void setLogType(final String logType) {
        this.logType = logType;
    }
    
    /**
     * @param multiple
     *            the multiple to set
     */
    public void setMultiple(final Integer multiple) {
        this.multiple = multiple;
    }
    
    /**
     * @param nameFile
     *            the nameFile to set
     */
    public void setNameFile(final String nameFile) {
        this.nameFile = nameFile;
    }
    
    /**
     * @param nameZip
     *            the nameZip to set
     */
    public void setNameZip(final String nameZip) {
        this.nameZip = nameZip;
    }
    
    /**
     * @param occurence
     *            the occurence to set
     */
    public void setOccurence(final Integer occurence) {
        this.occurence = occurence;
    }
    
    /**
     * @param profile
     *            the profile to set
     */
    public void setProfile(final String profile) {
        this.profile = profile;
    }
    
    /**
     * @param projectId
     *            the projectId to set
     */
    public void setProjectId(final String projectId) {
        this.projectId = projectId;
    }
    
    /**
     * @param releaseNumber
     *            the releaseNumber to set
     */
    public void setReleaseNumber(final String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }
}
