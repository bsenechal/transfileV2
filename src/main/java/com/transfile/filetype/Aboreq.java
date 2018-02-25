/*
 * 
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SUBAboreq;

@Component
public class Aboreq extends AFileType {

    @Value("${output.aboreq.path}")
    private String aboreqPath;

    @Value("${output.aboreq.name}")
    private String fileName;

    @Autowired
    private SUBAboreq subAboreq;

    @Override
    public void generateFile() {
        fileContent = subAboreq.getContent();

        super.appendFile();

    }

    @PostConstruct
    private void initialize() {
        super.fileName = fileName;
        super.filePath = aboreqPath;
    }
}
