/*
 *
 */
package com.transfile.configuration;

import java.util.List;

/**
 * Business logic to operate on the data {@link Configuration}
 *
 */
@FunctionalInterface
public interface IConfigurationService {

    /**
     * Find all Configuration by log type
     *
     * @param logType
     * @return List<Configuration>
     */
    public List<Configuration> findByLogType(String logType);
}
