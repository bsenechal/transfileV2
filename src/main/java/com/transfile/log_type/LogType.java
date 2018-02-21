/**
 *
 */
package com.transfile.log_type;

/**
 * Enumeration des scopes de transcodage.
 *
 * @author 636841
 *
 */
public enum LogType {
    /**
     *
     */
    SOB_REQUEST("sob-request"),
    
    /**
    *
    */
    SOB_RESPONSE("sob-response"),
   
    /**
     *
     */
    SUB("SUB"),

    /**
     *
     */
    matching("matching"),

    /**
     *
     */
    chargeback("chargeback"),

    /**
     *
     */
    wallet("wallet"),

    /**
     *
     */
    operation("operation"),

    /**
     *
     */
    transaction("transaction");

    private String value;

    /**
     * @param value
     */
    private LogType(final String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
