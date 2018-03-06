/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SUBAborep;
import com.transfile.stats.StatsException;

@Component
public class Aborep extends AFileType {

    @Value("${output.aborep.path}")
    private String aborepPath;

    @Value("${output.aborep.name}")
    private String aborepFileName;

    @Autowired
    private SUBAborep subAborep;

    @Override
    protected void generateContent() throws StatsException{
        content.append("# SUB");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(subAborep.getContent());
    }

    @PostConstruct
    private void initialize() {
        super.fileName = aborepFileName;
        super.filePath = aborepPath;
    }

}
