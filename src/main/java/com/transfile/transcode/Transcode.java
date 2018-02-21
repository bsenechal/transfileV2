package com.transfile.transcode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.transfile.log_type.LogType;

@Entity
@Table(name = "TRANSCODE")
public class Transcode {

    @Id
    @Column(name = "TRANSCODE_ID", precision = 11, scale = 0)
    private Integer transcodeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "LOG_TYPE", length = 255)
    private LogType logType;

    @Enumerated(EnumType.STRING)
    @Column(name = "VARIABLE_TYPE", length = 255)
    private VariableType variableType;
    
    @Column(name = "DB_VALUE", length = 255)
    private String dbValue;

    @Column(name = "CONF_VALUE", length = 255)
    private String confValue;

    /**
     * @return the transcodeId
     */
    public Integer getTranscodeId() {
        return transcodeId;
    }

    /**
     * @param transcodeId the transcodeId to set
     */
    public void setTranscodeId(Integer transcodeId) {
        this.transcodeId = transcodeId;
    }

    /**
     * @return the logType
     */
    public LogType getLogType() {
        return logType;
    }

    /**
     * @param logType the logType to set
     */
    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    /**
     * @return the variableType
     */
    public VariableType getVariableType() {
        return variableType;
    }

    /**
     * @param variableType the variableType to set
     */
    public void setVariableType(VariableType variableType) {
        this.variableType = variableType;
    }

    /**
     * @return the dbValue
     */
    public String getDbValue() {
        return dbValue;
    }

    /**
     * @param dbValue the dbValue to set
     */
    public void setDbValue(String dbValue) {
        this.dbValue = dbValue;
    }

    /**
     * @return the confValue
     */
    public String getConfValue() {
        return confValue;
    }

    /**
     * @param confValue the confValue to set
     */
    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }
}
