/**
 *
 */
package com.transfile.transcode;

/**
 *
 *
 */
public enum VariableType {
    
    /**
     *
     */
    PROTOCOL("PROTOCOL"),
    
    /**
     *
     */
    EXT("EXT"),
    
    /**
     *
     */
    BANK_NAME("BANK_NAME"),
    
    /**
     *
     */
    DATE_FORMAT("DATE_FORMAT"),
    
    /**
     *
     */
    DELETE("DELETE"),
    
    /**
     *
     */
    MULTIPLE("MULTIPLE");
    
    private String value;
    
    /**
     * @param value
     */
    private VariableType(final String value) {
        this.value = value;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
