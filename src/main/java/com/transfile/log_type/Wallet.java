package com.transfile.log_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.client.Client;
import com.transfile.configuration.Configuration;
import com.transfile.configuration.IConfigurationService;
import com.transfile.transcode.ITranscodeService;

@Component
public class Wallet extends ALogType {

    private static final String UBZ_WALLET = "ubz-wallet.expiring";

    private static final String FTP_B = "ftp_b";

    @Autowired
    private IConfigurationService configurationService;

    @Autowired
    private ITranscodeService transcodeService;

    @Override
    public String getContent() {
        final List<Configuration> configs = configurationService.findByLogType(LogType.wallet.getValue());
        String fileContent = ALogType.EMPTY;
        Client client;
        String defaultValue;
        String forcedValue;
        String forcedExtension;

        for (final Configuration config : configs) {
            client = config.getClient();

            defaultValue = config.getNameZip() + config.getOccurence() + ALogType.DOT
                    + transcodeService.getWalletNormalise(config.getExtention()) + ALogType.COLON + config.getNameFile()
                    + config.getOccurence();

            forcedValue = config.getForcedZipName() + ALogType.COLON + config.getForcedZipName();

            forcedExtension = config.getForcedFileName();

            fileContent = fileContent + Wallet.UBZ_WALLET + client.getMerchantId() + ALogType.DASH + client.getSipsAlias()
                    + ALogType.DOT + ALogType.ASTERIX + ALogType.COLON + config.getProfile() + ALogType.COLON
                    + client.getMerchantFtp() + ALogType.DOT + Wallet.FTP_B + ALogType.DOT
                    + checkForcedValue(config, forcedValue, forcedExtension, defaultValue) + ALogType.DOT
                    + transcodeService.getWalletNormalise(config.getDateFormat()) + ALogType.COLON
                    + transcodeService.getWalletNormalise(client.getProtocol()) + ALogType.COLON
                    + transcodeService.getWalletNormalise(String.valueOf(config.getDeleteFlag())) + ALogType.COLON
                    + transcodeService.getWalletNormalise(String.valueOf(config.getMultiple())) + ALogType.COLON
                    + System.getProperty("line.separator");
        }
        
        return fileContent.replace(ALogType.NULL, ALogType.EMPTY);
    }
}
