package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.transcode.ITranscodeService;

@Component
public class Matching extends ALogType {

    private static final String UBZ_MATCHING = "ubz-matching.jrb-report";

    private static final String FTP_B = "ftp_b";

    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.matching.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultValue;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue = config.getNameZip() + config.getOccurence()
                    + transcodeService.getMatchingNormalise(config.getExtention()) + ALogType.COLON
                    + config.getNameFile() + config.getOccurence();

            forcedValue = config.getForcedZipName() + config.getForcedFileName();

            forcedExtension = config.getForcedFileName();

            fileContent = fileContent + Matching.UBZ_MATCHING + ALogType.DOT
                    + transcodeService.getMatchingNormalise(client.getBankName()) + ALogType.DASH
                    + client.getMerchantId() + ALogType.DASH + client.getSipsAlias() + ALogType.DOT + ALogType.ASTERIX
                    + ALogType.COLON + config.getProfile() + ALogType.COLON + client.getMerchantFtp() + ALogType.DOT
                    + Matching.FTP_B + ALogType.DOT
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultValue) + ALogType.DOT
                    + transcodeService.getMatchingNormalise(config.getDateFormat()) + ALogType.COLON
                    + transcodeService.getMatchingNormalise(client.getProtocol()) + ALogType.COLON
                    + transcodeService.getMatchingNormalise(String.valueOf(config.getDeleteFlag())) + ALogType.COLON
                    + transcodeService.getMatchingNormalise(String.valueOf(config.getMultiple())) + ALogType.COLON
                    + System.getProperty("line.separator");

        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }

}
