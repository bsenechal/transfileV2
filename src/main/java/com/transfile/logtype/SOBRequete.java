/*
 *
 */
package com.transfile.logtype;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.transcode.VariableType;

@Component
public class SOBRequete extends ALogType {
    private static final String ZIP = "ZIP";

    private static final String OFFBATCH_ENC = "_OFFBATCH_ENC_";

    private static final String OFFICE = "office";

    @Override
    public String getContent() {
        configs = configurationService.findByLogType(LogType.SOB_request.getValue());

        for (final Configuration config : configs) {
            client = config.getClient();

            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());
            defaultValue.append(transcodeService.getSOBRequestNormalise(String.valueOf(config.getExtention()), VariableType.EXT));

            forcedValue.append(config.getForcedZipName());

            forcedExtension = null;

            fileContent.append(SOBRequete.ZIP);
            fileContent.append(ALogType.COLON);
            fileContent.append(client.getMerchantFtp().toUpperCase());
            fileContent.append(ALogType.DOT);
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.COLON);
            fileContent.append(SOBRequete.OFFBATCH_ENC);
            fileContent.append(ALogType.DOT);
            fileContent.append(client.getSipsAlias());
            fileContent.append(ALogType.DOT);
            fileContent.append(SOBRequete.OFFICE);
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }

        return fileContent.toString().replace(ALogType.NULL, ALogType.EMPTY);
    }
}
