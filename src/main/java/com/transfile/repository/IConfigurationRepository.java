package com.transfile.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.transfile.model.Configuration;

// Classe pour communiquer avec la BDD + Gestion des transactions
public interface IConfigurationRepository extends CrudRepository<Configuration, Long> {
    
    @Override
    public List<Configuration> findAll();
    
    public List<Configuration> findByLogType(String logType);
}
