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

    @Column(name = "DB_VALUE", length = 255)
    private String dbValue;

    @Column(name = "CONF_VALUE", length = 255)
    private String confValue;

    /**
     * @return the confValue
     */
    public String getConfValue() {
        return confValue;
    }

    /**
     * @return the dbValue
     */
    public String getDbValue() {
        return dbValue;
    }

    /**
     * @return the logType
     */
    public LogType getLogType() {
        return logType;
    }

    /**
     * @return the transcodeId
     */
    public Integer getTranscodeId() {
        return transcodeId;
    }

    /**
     * @param confValue
     *            the confValue to set
     */
    public void setConfValue(final String confValue) {
        this.confValue = confValue;
    }

    /**
     * @param dbValue
     *            the dbValue to set
     */
    public void setDbValue(final String dbValue) {
        this.dbValue = dbValue;
    }

    /**
     * @param logType
     *            the logType to set
     */
    public void setLogType(final LogType logType) {
        this.logType = logType;
    }

    /**
     * @param transcodeId
     *            the transcodeId to set
     */
    public void setTranscodeId(final Integer transcodeId) {
        this.transcodeId = transcodeId;
    }
}
