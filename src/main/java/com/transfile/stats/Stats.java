/**
 *
 */
package com.transfile.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "TF_STATS")
public class Stats {
    @Id
    @Column(name = "Id_STAT", precision = 11, scale = 0)
    private Integer idStat;

    @Column(name = "LOG_TYPE", length = 255)
    private String logType;

    @Column(name = "PREVIOUS_VALUE", precision = 11, scale = 0)
    private Integer previousValue;

    @Column(name = "DELTA_WARNING", precision = 11, scale = 0)
    private Integer deltaWarning;

    @Column(name = "DELTA_ERROR", precision = 11, scale = 0)
    private Integer deltaError;

    /**
     * @return the idStat
     */
    public final Integer getIdStat() {
        return idStat;
    }
    /**
     * @param idStat the idStat to set
     */
    public final void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }
    /**
     * @return the logType
     */
    public final String getLogType() {
        return logType;
    }
    /**
     * @param logType the logType to set
     */
    public final void setLogType(String logType) {
        this.logType = logType;
    }
    /**
     * @return the previousValue
     */
    public final Integer getPreviousValue() {
        return previousValue;
    }
    /**
     * @param previousValue the previousValue to set
     */
    public final void setPreviousValue(Integer previousValue) {
        this.previousValue = previousValue;
    }
    /**
     * @return the deltaWarning
     */
    public final Integer getDeltaWarning() {
        return deltaWarning;
    }
    /**
     * @param deltaWarning the deltaWarning to set
     */
    public final void setDeltaWarning(Integer deltaWarning) {
        this.deltaWarning = deltaWarning;
    }
    /**
     * @return the deltaError
     */
    public final Integer getDeltaError() {
        return deltaError;
    }
    /**
     * @param deltaError the deltaError to set
     */
    public final void setDeltaError(Integer deltaError) {
        this.deltaError = deltaError;
    }
}
