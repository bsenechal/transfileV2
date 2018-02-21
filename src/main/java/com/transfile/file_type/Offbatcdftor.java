package com.transfile.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.log_type.SOBOffbatcdftor;

@Component
public class Offbatcdftor extends AFileType {
    
    private static final String OFFBATCDFTOR = "offbatcdftor.conf";

    @Autowired
    private SOBOffbatcdftor sobOffbatcdftor;

    public Offbatcdftor() {
        super.fileName = OFFBATCDFTOR;
    }

    @Override
    public void generateFile() {
        fileContent = sobOffbatcdftor.getContent();

        super.appendFile();

    }

}
