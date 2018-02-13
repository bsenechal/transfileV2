package com.transfile.model.log_type;

import org.springframework.beans.factory.annotation.Autowired;

import com.transfile.service.IConfigurationService;

public abstract class ALogType {
    
    @Autowired
    protected IConfigurationService configurationService;
    
    public abstract String getContent();
    
}
