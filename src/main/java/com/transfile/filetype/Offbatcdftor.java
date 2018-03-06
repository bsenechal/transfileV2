/*
 *
 */
package com.transfile.filetype;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.transfile.logtype.SOBOffbatcdftor;
import com.transfile.stats.StatsException;

@Component
public class Offbatcdftor extends AFileType {

    @Autowired
    private SOBOffbatcdftor sobOffbatcdftor;

    @Value("${output.offbatcdftor.path}")
    private String offbatcdftorPath;

    @Value("${output.offbatcdftor.name}")
    private String offbatcdftorFileName;

    @Override
    protected void generateContent() throws StatsException {
        content.append("# SOB");
        content.append(System.getProperty(AFileType.LINE_SEPARATOR));
        content.append(sobOffbatcdftor.getContent());
    }

    @PostConstruct
    private void initialize() {
        super.fileName = offbatcdftorFileName;
        super.filePath = offbatcdftorPath;
    }
}
