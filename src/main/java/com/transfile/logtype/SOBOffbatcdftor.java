/*
 *
 */
package com.transfile.logtype;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.stats.StatsException;
import com.transfile.transcode.VariableType;

@Component
public class SOBOffbatcdftor extends ALogType {
    private static final String UBZIP = "ubzip:OFFUBZ.OFFBAREP";

    private static final String FTP_B = "ftp_b";

    @Override
    protected void generateContent() throws StatsException{
        super.logType = LogType.SOB_response;

        for (final Configuration config : configs) {
            client = config.getClient();

            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());
            defaultValue.append(transcodeService.getSOBResponseNormalise(String.valueOf(config.getExtention()), VariableType.EXT));
            defaultValue.append(ALogType.COLON);
            defaultValue.append(config.getNameFile());

            forcedValue.append(config.getForcedZipName());

            forcedValue.append(ALogType.COLON);
            forcedValue.append(config.getForcedFileName());

            forcedExtension.append(config.getForcedFileName());

            forcedExtension.append(ALogType.COLON);
            forcedExtension.append(config.getNameFile());

            fileContent.append(SOBOffbatcdftor.UBZIP);
            fileContent.append(ALogType.DOT);
            fileContent.append(client.getSipsAlias().toUpperCase());
            fileContent.append(ALogType.COLON);
            fileContent.append(client.getMerchantFtp());
            fileContent.append(ALogType.DOT);
            fileContent.append(SOBOffbatcdftor.FTP_B);
            fileContent.append(ALogType.DOT);
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getSOBResponseNormalise(client.getProtocol(), VariableType.PROTOCOL));
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }
    }

    @PostConstruct
    private void init () {
        super.logType = LogType.SOB_response;
    }
}
