package com.transfile.model.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.Client;
import com.transfile.model.Configuration;
import com.transfile.service.IConfigurationService;

@Component
public class Wallet extends ALogType {
    @Autowired
    private IConfigurationService configurationService;
    
    @Override
    public String getContent() {
        List<Configuration> configs =   configurationService.findByLogType("WALLET");
        String fileContent = null;
        Client client;
        
        for (Configuration config : configs) {
            client = config.getClient();
            fileContent = "ubz-wallet.expiring" + client.getMerchantId() + "-" + client.getSipsAlias() + ".*:" + config.getProfile() + ":" + client.getMerchantFtp() + ".ftp_b." + config.getNameZip() + config.getOccurence() + "." + config.getExtention() + ":" + config.getNameFile() + config.getOccurence() + "." + config.getDateFormat() + ":" + client.getProtocol() + ":" + config.getDeleteFlag() + ":" + config.getMultiple() + ":";
        }
        
        
        return String.join(System.getProperty("line.separator"), fileContent);
    }
    
}
