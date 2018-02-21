package com.transfile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.transfile.file_type.Aborep;
import com.transfile.file_type.Aboreq;
import com.transfile.file_type.Offbatcdftor;
import com.transfile.file_type.Requete;
import com.transfile.file_type.Sendfile;

@SpringBootApplication(scanBasePackages = "com.transfile", exclude = { EmbeddedServletContainerAutoConfiguration.class,
        WebMvcAutoConfiguration.class })
@Configuration
@EnableAutoConfiguration
@EntityScan
@EnableJpaRepositories
@EnableTransactionManagement
public class Application {
    private final static Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(final String[] args) {
        Application.LOGGER.info("Début du batch");

        SpringApplication.run(Application.class, args);

        Application.LOGGER.info("Fin du batch");
    }

    @Autowired
    private Sendfile sendfile;
    @Autowired
    private Aborep aborep;
    @Autowired
    private Aboreq aboreq;

    @Autowired
    private Offbatcdftor offbatcdftor;

    @Autowired
    private Requete requete;

    @Bean
    public CommandLineRunner run(final ApplicationContext appContext) {
        return args -> {

            final String param = "all";

            switch (param) {
            case "aborep": {
                aborep.generateFile();
                break;
            }

            case "aboreq": {
                aboreq.generateFile();
                break;
            }

            case "offbatcdftor": {
                offbatcdftor.generateFile();
                break;
            }
            case "requete": {
                requete.generateFile();
                break;
            }

            case "sendfile": {
                sendfile.generateFile();
                break;
            }
            case "all": {
                aborep.generateFile();
                aboreq.generateFile();
                offbatcdftor.generateFile();
                requete.generateFile();
                sendfile.generateFile();
                break;
            }
            default: {
                throw new Exception("Nom de fichier à générer inconnu");
            }
            }
        };
    }

}
