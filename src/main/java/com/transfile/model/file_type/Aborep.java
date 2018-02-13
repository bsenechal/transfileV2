package com.transfile.model.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.log_type.SUBAborep;

@Component
public class Aborep extends AFileType {
    
    @Autowired
    private SUBAborep subAborep;
    
    public Aborep() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "aborep.ini";
    }
    
    @Override
    public void generateFile() {
        
        fileContent = subAborep.getContent();
        
        super.appendFile();
        
    }
    
}
