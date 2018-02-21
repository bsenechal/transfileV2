package com.transfile.log_type;

import org.springframework.beans.factory.annotation.Autowired;

import com.transfile.configuration.Configuration;
import com.transfile.configuration.IConfigurationService;

public abstract class ALogType {

    protected static final String COLON = ":";

    protected static final String DOT = ".";

    protected static final String DASH = "-";

    protected static final String ASTERIX = "*";

    protected static final String NULL = "null";

    protected static final String EMPTY = "";

    @Autowired
    protected IConfigurationService configurationService;

    public String checkForcedValue(final Configuration config, final String forcedValue, final String forcedExtension,
            final String defaultValue) {
        String result = ALogType.EMPTY;

        if (config.getForcedFileName() != null || config.getForcedZipName() != null) {
            result = forcedValue;
        } else if (config.getExtention() != null && forcedExtension != null) {
            result = forcedExtension;
        } else {
            result = defaultValue;
        }

        return result;
    }

    public abstract String getContent();

}
