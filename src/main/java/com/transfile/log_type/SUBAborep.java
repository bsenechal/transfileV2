package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.transcode.ITranscodeService;

@Component
public class SUBAborep extends ALogType {
    private static final String SUBUBZ = "SUBUBZ";
    private static final String ABOREPNET = "ABOREPNET";
    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.SUB_response.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultValue;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue = config.getNameZip() + config.getOccurence()
                    + transcodeService.getSUBResponseNormalise(config.getExtention());

            forcedValue = config.getForcedFileName();

            forcedExtension = null;

            // Il manque le SIPS_ALIAS
            fileContent = fileContent + SUBAborep.SUBUBZ + ALogType.DOT + SUBAborep.ABOREPNET + ALogType.DOT + client.getSipsAlias()
                    + ALogType.DOT + ALogType.ASTERIX + ALogType.COLON + SUBAborep.ABOREPNET + ALogType.COLON
                    + client.getMerchantFtp() + checkForcedValue(config, forcedValue, forcedExtension, defaultValue)
                    + ALogType.COLON + transcodeService.getSUBResponseNormalise(client.getProtocol())
                    + System.getProperty("line.separator");
        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }

}
