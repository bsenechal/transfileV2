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
    private String fileName;

    // ----> A décommenter pour la migration de Requete et Offbatcdftor dans
    // sendfile
    // @Autowired
    // private SOBOffbatcdftor sobOffbatcdftor;
    //
    // @Autowired
    // private SOBRequete sobRequete;

    @Override
    public void generateFile() {
        final StringBuilder content = new StringBuilder();

        content.append(matching.getContent());
        content.append(chargeback.getContent());
        content.append(wallet.getContent());
        content.append(operation.getContent());
        content.append(transaction.getContent());

        // ----> A décommenter pour la migration de Requete et Offbatcdftor dans
        // sendfile
        // content.append(sobOffbatcdftor.getContent());
        // content.append(sobRequete.getContent());

        super.fileContent = content.toString();

        super.appendFile();
    }

    @PostConstruct
    private void initialize() {
        super.fileName = fileName;
        super.filePath = sendfilePath;
    }
}
