package com.transfile.configuration;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConfigurationService implements IConfigurationService {

    @Autowired
    private IConfigurationRepository configurationRepository;

    @Override
    public List<Configuration> findByLogType(final String logType) {
        return configurationRepository.findByLogType(logType);
    }
}
