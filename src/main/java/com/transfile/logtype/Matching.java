/*
 *
 */
package com.transfile.logtype;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.transcode.VariableType;

@Component
public class Matching extends ALogType {

    private static final String UBZ_MATCHING = "ubz-matching.jrb-report";

    private static final String FTP_B = "ftp_b";

    @Override
    public String getContent() {
        configs = configurationService.findByLogType(LogType.matching.getValue());

        for (final Configuration config : configs) {
            client = config.getClient();

            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());
            defaultValue.append(transcodeService.getMatchingNormalise(config.getExtention(), VariableType.EXT));
            defaultValue.append(ALogType.COLON);
            defaultValue.append(config.getNameFile() + config.getOccurence());

            forcedValue.append(config.getForcedZipName());

            forcedValue.append(ALogType.COLON);

            forcedValue.append(config.getForcedFileName());

            forcedExtension.append(config.getForcedFileName());

            fileContent.append(Matching.UBZ_MATCHING);
            fileContent.append(ALogType.DOT);
            fileContent.append(transcodeService.getMatchingNormalise(client.getBankName(), VariableType.BANK_NAME));
            fileContent.append(ALogType.DASH);
            fileContent.append(client.getMerchantId());
            fileContent.append(ALogType.DASH);
            fileContent.append(client.getSipsAlias());
            fileContent.append(ALogType.DOT);
            fileContent.append(ALogType.ASTERIX);
            fileContent.append(ALogType.COLON);
            fileContent.append(config.getProfile());
            fileContent.append(ALogType.COLON);
            fileContent.append(client.getMerchantFtp());
            fileContent.append(ALogType.DOT);
            fileContent.append(Matching.FTP_B);
            fileContent.append(ALogType.DOT);
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.DOT);
            fileContent.append(transcodeService.getMatchingNormalise(config.getDateFormat(), VariableType.DATE_FORMAT));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getMatchingNormalise(client.getProtocol(), VariableType.PROTOCOL));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getMatchingNormalise(String.valueOf(config.getDeleteFlag()), VariableType.DELETE));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getMatchingNormalise(String.valueOf(config.getMultiple()), VariableType.MULTIPLE));
            fileContent.append(ALogType.COLON);
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }

        return fileContent.toString().replace(ALogType.NULL, ALogType.EMPTY);
    }

}
