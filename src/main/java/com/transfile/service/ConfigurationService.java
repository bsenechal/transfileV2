package com.transfile.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfile.model.Configuration;
import com.transfile.repository.IConfigurationRepository;

@Service
@Transactional
// Gestion des erreurs + logique métier (nettoyage de données)
public class ConfigurationService {

	@Autowired
	private IConfigurationRepository configurationRepository;
	
	public List<Configuration> findAll() {
		return configurationRepository.findAll();
	}
}
