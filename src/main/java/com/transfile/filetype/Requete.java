/*
 * 
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SOBRequete;

@Component
public class Requete extends AFileType {

    @Autowired
    private SOBRequete sobRequete;

    @Value("${output.requete.path}")
    private String requetePath;

    @Value("${output.requete.name}")
    private String fileName;

    @Override
    public void generateFile() {
        final StringBuilder content = new StringBuilder();
        
        content.append("# SOB");
        content.append(System.getProperty("line.separator"));
        content.append(sobRequete.getContent());

        fileContent = content.toString();
        
        super.appendFile();
    }

    @PostConstruct
    private void initialize() {
        super.fileName = fileName;
        super.filePath = requetePath;
    }
}
