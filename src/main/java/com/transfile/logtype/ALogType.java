/*
 *
 */
package com.transfile.logtype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.configuration.IConfigurationService;
import com.transfile.transcode.ITranscodeService;

/**
 *
 *
 */
public abstract class ALogType {
    
    protected static final String COLON = ":";
    
    protected static final String DOT = ".";
    
    protected static final String DASH = "-";
    
    protected static final String ASTERIX = "*";
    
    protected static final String NULL = "null";
    
    protected static final String EMPTY = "";
    
    protected static final String ZIP_EXTENSION = "zip";

    protected static final String LINE_SEPARATOR = "line.separator";
    
    protected StringBuilder defaultValue = new StringBuilder();
    protected StringBuilder forcedValue = new StringBuilder();
    protected StringBuilder forcedExtension = new StringBuilder();
    protected StringBuilder fileContent = new StringBuilder();
    protected List<Configuration> configs;
    protected Client client;
    
    @Autowired
    protected IConfigurationService configurationService;
    @Autowired
    protected ITranscodeService transcodeService;
    
    public StringBuilder checkForcedValue(final Configuration config, final StringBuilder forcedValue, final StringBuilder forcedExtension,
            final StringBuilder defaultValue) {
        StringBuilder result = new StringBuilder();
        
        if (config.getForcedFileName() != null || config.getForcedZipName() != null) {
            result.append(forcedValue);
        } else if (!ALogType.ZIP_EXTENSION.equalsIgnoreCase(config.getExtention())) {
            result = forcedExtension;
        } else {
            result.append(defaultValue);
        }
        
        return result;
    }
    
    public abstract String getContent();
    
}
