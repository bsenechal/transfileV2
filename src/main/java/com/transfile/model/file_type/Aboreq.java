package com.transfile.model.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.log_type.SUBAboreq;

@Component
public class Aboreq extends AFileType {
    
    @Autowired
    private SUBAboreq subAboreq;
    
    public Aboreq() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "aboreq.ini";
    }
    
    @Override
    public void generateFile() {
        fileContent = subAboreq.getContent();
        
        super.appendFile();
        
    }
    
}
