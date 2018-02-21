package com.transfile.file_type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.log_type.Chargeback;
import com.transfile.log_type.Matching;
import com.transfile.log_type.Operation;
import com.transfile.log_type.Transaction;
import com.transfile.log_type.Wallet;

@Component
public class Sendfile extends AFileType {
    
    private static final String SENDFILE = "sendfile.conf";
    
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
    
    public Sendfile() {
        super.fileName = SENDFILE;
    }

    @Override
    public void generateFile() {
        final List<String> content = new ArrayList<>();

        content.add(matching.getContent());
        content.add(chargeback.getContent());
        content.add(wallet.getContent());
        content.add(operation.getContent());
        content.add(transaction.getContent());

        super.fileContent = content.stream().collect(Collectors.joining());

        super.appendFile();

    }

}
