package com.transfile.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.log_type.SUBAborep;

@Component
public class Aborep extends AFileType {

    private static final String ABOREP = "aborep.ini";
    
    @Autowired
    private SUBAborep subAborep;

    public Aborep() {
        super.fileName = ABOREP;
    }

    @Override
    public void generateFile() {

        fileContent = subAborep.getContent();

        super.appendFile();

    }

}
