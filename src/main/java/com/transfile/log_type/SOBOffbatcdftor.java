package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.transcode.ITranscodeService;

@Component
public class SOBOffbatcdftor extends ALogType {
    private static final String UBZIP = "ubzip:OFFUBZ.OFFBAREP";

    private static final String FTP_B = "ftp_b";

    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.SOB.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultZipName;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultZipName = config.getNameZip() + config.getOccurence()
                    + transcodeService.getSOBNormalise(String.valueOf(config.getOccurence()));

            forcedValue = config.getForcedZipName() + ALogType.COLON + config.getForcedFileName();

            forcedExtension = config.getForcedFileName() + ALogType.COLON + config.getNameFile();

            // Il manque le SIPS_ALIAS
            fileContent = fileContent + SOBOffbatcdftor.UBZIP + ALogType.DOT + client.getSipsAlias() + ALogType.COLON
                    + client.getMerchantFtp() + ALogType.DOT + SOBOffbatcdftor.FTP_B + ALogType.DOT
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultZipName) + ALogType.COLON
                    + transcodeService.getSOBNormalise(client.getProtocol())
                    + System.getProperty("line.separator");
        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }
}
