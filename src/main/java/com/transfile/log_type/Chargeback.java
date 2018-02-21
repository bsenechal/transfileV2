package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.configuration.IConfigurationService;
import com.transfile.transcode.ITranscodeService;

@Component
public class Chargeback extends ALogType {

    private static final String UBZ_CHARGEBACK = "ubz-chargeback.jri-report";

    private static final String FTP_B = "ftp_b";

    @Autowired
    private IConfigurationService configurationService;

    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.chargeback.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultZipName;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();

            defaultZipName = config.getNameZip() + config.getOccurence() + ALogType.DOT
                    + transcodeService.getChargebackNormalise(config.getExtention()) + ALogType.COLON
                    + config.getNameFile() + config.getOccurence();

            forcedValue = config.getForcedZipName() + ALogType.COLON + config.getForcedZipName();

            forcedExtension = config.getForcedFileName();

            fileContent = fileContent + Chargeback.UBZ_CHARGEBACK + ALogType.DOT
                    + transcodeService.getChargebackNormalise(client.getBankName()) + ALogType.DASH
                    + client.getMerchantId() + ALogType.DASH + client.getSipsAlias() + ALogType.DOT + ALogType.ASTERIX
                    + ALogType.COLON + config.getProfile() + ALogType.COLON + client.getMerchantFtp() + ALogType.DOT
                    + Chargeback.FTP_B + ALogType.DOT
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultZipName) + ALogType.DOT
                    + transcodeService.getChargebackNormalise(config.getDateFormat()) + ALogType.COLON
                    + transcodeService.getChargebackNormalise(client.getProtocol()) + ALogType.COLON
                    + transcodeService.getChargebackNormalise(String.valueOf(config.getDeleteFlag())) + ALogType.COLON
                    + transcodeService.getChargebackNormalise(String.valueOf(config.getMultiple())) + ALogType.COLON
                    + System.getProperty("line.separator");
        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }

}
