/**
 *
 */
package com.transfile.logtype;

public enum LogType {
    /**
     *
     */
    SOB_request("SOB_request"),
    
    /**
    *
    */
    SOB_response("SOB_response"),
    
    /**
    *
    */
    SUB_request("SUB_request"),
    
    /**
    *
    */
    SUB_response("SUB_response"),
    
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
