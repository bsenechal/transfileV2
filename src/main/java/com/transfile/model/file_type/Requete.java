package com.transfile.model.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.model.log_type.SOBRequete;

@Component
public class Requete extends AFileType {
    
    @Autowired
    private SOBRequete sobRequete;
    
    public Requete() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "sendfile.conf";
    }
    
    @Override
    public void generateFile() {
        fileContent = sobRequete.getContent();
        
        super.appendFile();
        
    }
    
}
