/*
 *
 */
package com.transfile.configuration;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Implements {@link IConfigurationService}
 *
 */
@Service
@Transactional
public class ConfigurationService implements IConfigurationService {

    @Autowired
    private IConfigurationRepository configurationRepository;

    @Override
    public List<Configuration> findByLogType(final String logType) {
        return configurationRepository.findByLogTypeOrderByClient(logType);
    }
}
