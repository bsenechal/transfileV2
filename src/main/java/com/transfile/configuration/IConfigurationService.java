package com.transfile.configuration;

import java.util.List;

public interface IConfigurationService {

    public List<Configuration> findByLogType(String logType);
}
