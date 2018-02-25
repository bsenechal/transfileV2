/*
 * 
 */
package com.transfile.logtype;

import java.util.List;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;

@Component
public class SUBAboreq extends ALogType {

    private static final String PAYMENT_7Z = "payment:7za";

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.SUB_request.getValue());

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());

            forcedValue.append(config.getForcedFileName());

            forcedExtension = null;

            fileContent.append(client.getMerchantFtp().toUpperCase());
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.COLON);
            fileContent.append(ALogType.DOT);
            fileContent.append(SUBAboreq.PAYMENT_7Z);
            fileContent.append(System.getProperty("line.separator"));
        }

        return fileContent.toString().replace(ALogType.NULL, ALogType.EMPTY);
    }

}
