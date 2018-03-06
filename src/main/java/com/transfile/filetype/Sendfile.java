/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.Chargeback;
import com.transfile.logtype.Matching;
import com.transfile.logtype.Operation;
import com.transfile.logtype.Transaction;
import com.transfile.logtype.Wallet;
import com.transfile.stats.StatsException;

@Component
public class Sendfile extends AFileType {

    @Autowired
    private Matching matching;

    @Autowired
    private Chargeback chargeback;

    @Autowired
    private Operation operation;

    @Autowired
    private Transaction transaction;

    @Autowired
    private Wallet wallet;

    @Value("${output.sendfile.path}")
    private String sendfilePath;

    @Value("${output.sendfile.name}")
    private String sendfileFileName;

    // ----> A décommenter pour la migration de Requete et Offbatcdftor dans
    // sendfile
    // @Autowired
    // private SOBOffbatcdftor sobOffbatcdftor;
    //
    // @Autowired
    // private SOBRequete sobRequete;

    @Override
    protected void generateContent() throws StatsException{
        content.append("# Matching");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(matching.getContent());
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));

        content.append("# Chargeback");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(chargeback.getContent());
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));

        content.append("# Wallet");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(wallet.getContent());
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));

        content.append("# Operation");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(operation.getContent());
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));

        content.append("# Transaction");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(transaction.getContent());
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));

        // ----> A décommenter pour la migration de Requete et Offbatcdftor dans
        // content.append("# SOB");
        // content.append(System.getProperty("line.separator"));
        // content.append(sobOffbatcdftor.getContent());
        // content.append(System.getProperty("line.separator"));
        //
        // content.append(System.getProperty("line.separator"));
        // content.append(sobRequete.getContent());
        // content.append(System.getProperty("line.separator"));
    }

    @PostConstruct
    private void initialize() {
        super.fileName = sendfileFileName;
        super.filePath = sendfilePath;
    }
}
