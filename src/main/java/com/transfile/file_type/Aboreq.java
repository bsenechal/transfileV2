package com.transfile.file_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transfile.log_type.SUBAboreq;

@Component
public class Aboreq extends AFileType {

    private static final String ABOREQ = "aboreq.ini";
    
    @Autowired
    private SUBAboreq subAboreq;

    public Aboreq() {
        super.fileName = ABOREQ;
    }

    @Override
    public void generateFile() {
        fileContent = subAboreq.getContent();

        super.appendFile();

    }

}
