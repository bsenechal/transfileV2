package com.transfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.transfile.service.ConfigurationService;

@SpringBootApplication(scanBasePackages = "com.transfile")
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.transfile.model" })
@EnableJpaRepositories(basePackages = { "com.transfile.repository" })
@EnableTransactionManagement
public class Application {
	
	@Autowired
	private ConfigurationService configurationService;
	
	// TODO --> Autowired
	
    public static void main(String[] args) {
    	
    	System.out.println("Début du batch");
        SpringApplication.run(Application.class, args);
        
        System.out.println("Fin du batch");
        

    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

        	// Récupère les données
        	List<com.transfile.model.Configuration> configs = configurationService.findAll();

        	// Affiche 
        	for (com.transfile.model.Configuration config : configs) {
        		
        		System.out.println(config.getConfigId());
        		
        		System.out.println(config.getNameFile());
        	}
        	
        	
        	// TODO faire pareil Client
        	// Le bean client avec les annotations de mapping pour la BDD
        	// IClientService : Ensemble des comportements / Déclaration des fonctions
        	// ClientService : Appeler le IClientRepository
        	// IClientRepository : Comme l'autre x) 
        	
        };
    }

}