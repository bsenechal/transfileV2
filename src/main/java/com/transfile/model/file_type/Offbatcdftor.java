package com.transfile.model.file_type;

import com.transfile.model.file_type.AFileType;
import com.transfile.model.log_type.SOBOffbatcdftor;

public class Offbatcdftor extends AFileType {
	
	public Offbatcdftor() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "offbatcdftor.conf";
	}
	
	@Override
	public void generateFile() {
		SOBOffbatcdftor sobOffbatcdftor = new SOBOffbatcdftor();
		
		fileContent = sobOffbatcdftor.getContent();
		
		super.appendFile();
		
	}

}
