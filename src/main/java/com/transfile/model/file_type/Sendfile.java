package com.transfile.model.file_type;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.log_type.Chargeback;
import com.transfile.model.log_type.Matching;
import com.transfile.model.log_type.Operation;
import com.transfile.model.log_type.Transaction;
import com.transfile.model.log_type.Wallet;

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
    
    public Sendfile() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "sendfile.conf";
    }
    
    @Override
    public void generateFile() {
        final List<String> content = new ArrayList<>();
        
        content.add(matching.getContent());
        content.add(chargeback.getContent());
        content.add(wallet.getContent());
        content.add(operation.getContent());
        content.add(transaction.getContent());
        
        super.fileContent = String.join(System.getProperty("line.separator"), content);
        
        super.appendFile();
        
    }
    
}
