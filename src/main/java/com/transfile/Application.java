/*
 * 
 */
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

import com.transfile.filetype.Aborep;
import com.transfile.filetype.Aboreq;
import com.transfile.filetype.Flag;
import com.transfile.filetype.Offbatcdftor;
import com.transfile.filetype.Requete;
import com.transfile.filetype.Sendfile;

/**
 * Main class
 *
 */
@SpringBootApplication(scanBasePackages = "com.transfile", exclude = { EmbeddedServletContainerAutoConfiguration.class,
        WebMvcAutoConfiguration.class })
@Configuration
@EnableAutoConfiguration
@EntityScan
@EnableJpaRepositories
@EnableTransactionManagement
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(final String[] args) {
        Application.LOGGER.info("Starting Transfile application");

        SpringApplication.run(Application.class, args);

        Application.LOGGER.info("Transfile application ended without error");
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

    @Autowired
    private Flag flag;

    private void launchFileGeneration(final String fileName) {
        flag.generateFile();

        switch (fileName) {
        case "aborep":
            aborep.generateFile();
            break;

        case "aboreq":
            aboreq.generateFile();
            break;

        case "offbatcdftor":
            offbatcdftor.generateFile();
            break;

        case "requete":
            requete.generateFile();
            break;

        case "sendfile":
            sendfile.generateFile();
            break;

        default:
            aborep.generateFile();
            aboreq.generateFile();
            offbatcdftor.generateFile();
            requete.generateFile();
            sendfile.generateFile();
        }
    }

    @Bean
    public CommandLineRunner run(final ApplicationContext appContext) {
        return args -> {
            String fileName = "";

            if (args.length > 0) {
                fileName = args[0];
            }

            launchFileGeneration(fileName);

        };
    }
}
