/*
 * 
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SUBAborep;

@Component
public class Aborep extends AFileType {

    @Value("${output.aborep.path}")
    private String aborepPath;

    @Value("${output.aborep.name}")
    private String aborepFileName;

    @Autowired
    private SUBAborep subAborep;

    @Override
    public void generateFile() {
        final StringBuilder content = new StringBuilder();
        
        content.append("# SUB");
        content.append(System.getProperty("line.separator"));
        content.append(subAborep.getContent());
        
        fileContent = content.toString();

        super.appendFile();

    }

    @PostConstruct
    private void initialize() {
        super.fileName = aborepFileName;
        super.filePath = aborepPath;
    }

}
