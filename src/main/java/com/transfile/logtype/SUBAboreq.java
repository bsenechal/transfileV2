/*
 *
 */
package com.transfile.logtype;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.stats.StatsException;

@Component
public class SUBAboreq extends ALogType {

    private static final String PAYMENT_7Z = "payment:7za";

    @Override
    protected void generateContent() throws StatsException{
        super.logType = LogType.SUB_request;

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
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }
    }

    @PostConstruct
    private void init () {
        super.logType = LogType.SUB_request;
    }
}
