package com.transfile.model.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.log_type.SOBOffbatcdftor;

@Component
public class Offbatcdftor extends AFileType {
    
    @Autowired
    private SOBOffbatcdftor sobOffbatcdftor;
    
    public Offbatcdftor() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "offbatcdftor.conf";
    }
    
    @Override
    public void generateFile() {
        fileContent = sobOffbatcdftor.getContent();
        
        super.appendFile();
        
    }
    
}
