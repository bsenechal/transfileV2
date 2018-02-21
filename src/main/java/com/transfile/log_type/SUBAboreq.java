package com.transfile.log_type;

import java.util.List;

import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;

@Component
public class SUBAboreq extends ALogType {

    private static final String PAYMENT_7Z = "payment:7za";

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.SUB_request.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultValue;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue = config.getNameZip() + config.getOccurence();

            forcedValue = config.getForcedFileName();

            forcedExtension = null;

            // Il manque le SIPS_ALIAS
            fileContent = fileContent + client.getMerchantFtp()
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultValue) + ALogType.COLON
                    + ALogType.DOT + SUBAboreq.PAYMENT_7Z
                    + System.getProperty("line.separator");
        }

        fileContent = fileContent.replace(ALogType.NULL, ALogType.EMPTY);

        return fileContent;
    }

}
