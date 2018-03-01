/*
 *
 */
package com.transfile.configuration;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * CRUD repository to manage {@link Configuration}
 *
 */
public interface IConfigurationRepository extends CrudRepository<Configuration, Long> {
    
    /**
     * Find all Configuration by log type
     *
     * @param logType
     * @return List<Configuration>
     */
    public List<Configuration> findByLogTypeOrderByClient(String logType);
}
