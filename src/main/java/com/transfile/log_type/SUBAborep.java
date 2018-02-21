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
        final List<Configuration> configs = configurationService.findByLogType(LogType.SUB.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultZipName;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultZipName = config.getNameZip() + config.getOccurence()
                    + transcodeService.getSUBNormalise(config.getExtention());

            forcedValue = config.getForcedFileName();

            forcedExtension = null;

            // Il manque le SIPS_ALIAS
            fileContent = fileContent + SUBAborep.SUBUBZ + ALogType.DOT + SUBAborep.ABOREPNET + ALogType.DOT + client.getSipsAlias()
                    + ALogType.DOT + ALogType.ASTERIX + ALogType.COLON + SUBAborep.ABOREPNET + ALogType.COLON
                    + client.getMerchantFtp() + checkForcedValue(config, forcedValue, forcedExtension, defaultZipName)
                    + ALogType.COLON + transcodeService.getSUBNormalise(client.getProtocol())
                    + System.getProperty("line.separator");
        }

        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }

}
