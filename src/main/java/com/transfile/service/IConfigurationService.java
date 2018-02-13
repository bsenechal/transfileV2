package com.transfile.service;

import java.util.List;

import com.transfile.model.Configuration;

public interface IConfigurationService {
    
    public List<Configuration> findAll();
    
    public List<Configuration> findByLogType(String logType);
}
