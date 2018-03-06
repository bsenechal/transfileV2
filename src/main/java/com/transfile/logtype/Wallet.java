/*
 *
 */
package com.transfile.logtype;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.transfile.configuration.Configuration;
import com.transfile.stats.StatsException;
import com.transfile.transcode.VariableType;

@Component
public class Wallet extends ALogType {

    private static final String UBZ_WALLET = "ubz-wallet.expiring";

    private static final String FTP_B = "ftp_b";

    @Override
    protected void generateContent() throws StatsException{

        for (final Configuration config : configs) {
            client = config.getClient();
            defaultValue.append(config.getNameZip());
            defaultValue.append(config.getOccurence());
            defaultValue.append(ALogType.DOT);
            defaultValue.append(transcodeService.getWalletNormalise(config.getExtention(), VariableType.EXT));
            defaultValue.append(ALogType.COLON);
            defaultValue.append(config.getNameFile());
            defaultValue.append(config.getOccurence());

            forcedValue.append(config.getForcedZipName());
            forcedValue.append(ALogType.COLON);
            forcedValue.append(config.getForcedFileName());

            forcedExtension.append(config.getForcedFileName());

            fileContent.append(Wallet.UBZ_WALLET);
            fileContent.append(ALogType.DOT);
            fileContent.append(client.getMerchantId());
            fileContent.append(ALogType.DASH);
            fileContent.append(client.getSipsAlias());
            fileContent.append(ALogType.DOT);
            fileContent.append(ALogType.ASTERIX);
            fileContent.append(ALogType.COLON);
            fileContent.append(config.getProfile().toUpperCase());
            fileContent.append(ALogType.COLON);
            fileContent.append(client.getMerchantFtp());
            fileContent.append(ALogType.DOT);
            fileContent.append(Wallet.FTP_B);
            fileContent.append(ALogType.DOT);
            fileContent.append(checkForcedValue(config, forcedValue, forcedExtension, defaultValue));
            fileContent.append(ALogType.DOT);
            fileContent.append(transcodeService.getWalletNormalise(config.getDateFormat(), VariableType.DATE_FORMAT));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getWalletNormalise(client.getProtocol(), VariableType.PROTOCOL));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getWalletNormalise(String.valueOf(config.getDeleteFlag()), VariableType.DELETE));
            fileContent.append(ALogType.COLON);
            fileContent.append(transcodeService.getWalletNormalise(String.valueOf(config.getMultiple()), VariableType.MULTIPLE));
            fileContent.append(ALogType.COLON);
            fileContent.append(System.getProperty(ALogType.LINE_SEPARATOR));
        }
    }

    @PostConstruct
    private void init () {
        super.logType = LogType.wallet;
    }
}
