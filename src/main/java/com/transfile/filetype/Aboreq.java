/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SUBAboreq;
import com.transfile.stats.StatsException;

@Component
public class Aboreq extends AFileType {

    @Value("${output.aboreq.path}")
    private String aboreqPath;

    @Value("${output.aboreq.name}")
    private String aboreqFileName;

    @Autowired
    private SUBAboreq subAboreq;

    @Override
    protected void generateContent() throws StatsException {
        content.append("# SUB");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(subAboreq.getContent());
    }

    @PostConstruct
    private void initialize() {
        super.fileName = aboreqFileName;
        super.filePath = aboreqPath;
    }
}
