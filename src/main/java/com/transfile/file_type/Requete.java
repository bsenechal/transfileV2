package com.transfile.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.log_type.SOBRequete;

@Component
public class Requete extends AFileType {

    private static final String REQUETE = "requete.conf";
    
    @Autowired
    private SOBRequete sobRequete;

    public Requete() {
        super.fileName = REQUETE;
    }

    @Override
    public void generateFile() {
        fileContent = sobRequete.getContent();

        super.appendFile();

    }

}
