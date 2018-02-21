package com.transfile.configuration;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IConfigurationRepository extends CrudRepository<Configuration, Long> {

    public List<Configuration> findByLogType(String logType);
}
