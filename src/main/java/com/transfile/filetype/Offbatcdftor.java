/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SOBOffbatcdftor;

@Component
public class Offbatcdftor extends AFileType {

    @Autowired
    private SOBOffbatcdftor sobOffbatcdftor;

    @Value("${output.offbatcdftor.path}")
    private String offbatcdftorPath;

    @Value("${output.offbatcdftor.name}")
    private String offbatcdftorFileName;

    @Override
    public void generateFile() {
        final StringBuilder content = new StringBuilder();
        
        content.append("# SOB");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(sobOffbatcdftor.getContent());
        
        fileContent = content.toString();
        
        super.appendFile();
    }

    @PostConstruct
    private void initialize() {
        super.fileName = offbatcdftorFileName;
        super.filePath = offbatcdftorPath;
    }
}
