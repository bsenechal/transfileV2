/*
 *
 */
package com.transfile.logtype;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.transcode.VariableType;

@Component
public class SUBAborep extends ALogType {
    private static final String SUBUBZ = "SUBUBZ";
    private static final String ABOREPNET = "ABOREPNET";
    
    @Override
    public String getContent() {
        configs = configurationService.findByLogType(LogType.SUB_response.getValue());
        
        for (final Configuration config : configs) {
            client = config.getClient();
            
            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());
            defaultValue.append(transcodeService.getSUBResponseNormalise(config.getExtention(), VariableType.EXT));
            
            forcedValue.append(config.getForcedFileName());
            
            forcedExtension = null;
            
            fileContent.append(SUBAborep.SUBUBZ);
            fileContent.append(ALogType.DOT);
            fileContent.append(SUBAborep.ABOREPNET);
            fileContent.append(ALogType.DOT);
            fileContent.append(client.getSipsAlias());
            fileContent.append(ALogType.DOT);
            fileContent.append(ALogType.ASTERIX);
            fileContent.append(ALogType.COLON);
            fileContent.append(SUBAborep.ABOREPNET);
            fileContent.append(ALogType.COLON);
            fileContent.append(client.getMerchantFtp());
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getSUBResponseNormalise(client.getProtocol(), VariableType.PROTOCOL));
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }
        
        return fileContent.toString().replace(ALogType.NULL, ALogType.EMPTY);
    }
    
}
