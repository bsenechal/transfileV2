/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Flag extends AFileType {

    @Value("${output.flag.path}")
    private String flagPath;

    @Value("${output.flag.name}")
    private String flagFileName;

    @Override
    public void generateFile() {

        fileContent = "";

        super.appendFile();

    }

    @PostConstruct
    private void initialize() {
        super.fileName = flagFileName;
        super.filePath = flagPath;
    }

}
