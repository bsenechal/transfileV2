package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.transcode.ITranscodeService;

@Component
public class SOBRequete extends ALogType {
    private static final String ZIP = "ZIP";

    private static final String OFFBATCH_ENC = "_OFFBATCH_ENC_";

    private static final String OFFICE = "office";

    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.SOB_request.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultValue;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue = config.getNameZip() + config.getOccurence()
                    + transcodeService.getSOBRequestNormalise(String.valueOf(config.getOccurence()));

            forcedValue = config.getForcedZipName();

            forcedExtension = null;

            // Il manque le SIPS_ALIAS
            fileContent = fileContent + SOBRequete.ZIP + ALogType.COLON + client.getMerchantFtp() + ALogType.DOT
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultValue) + ALogType.COLON
                    + SOBRequete.OFFBATCH_ENC + ALogType.DOT + ALogType.DOT + SOBRequete.OFFICE
                    + System.getProperty("line.separator");
        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }
}
