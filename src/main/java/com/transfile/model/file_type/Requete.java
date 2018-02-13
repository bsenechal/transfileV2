package com.transfile.model.file_type;

import com.transfile.model.log_type.SOBRequete;

public class Requete extends AFileType {
    
    public Requete() {
        super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
        super.fileName = "sendfile.conf";
    }
    
    @Override
    public void generateFile() {
        final SOBRequete sobRequete = new SOBRequete();
        
        fileContent = sobRequete.getContent();
        
        super.appendFile();
        
    }
    
}
