package com.transfile.model.file_type;

import com.transfile.model.log_type.SUBArborep;

public class Aborep extends AFileType {
	
	public Aborep() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "aborep.ini";
	}
	
	@Override
	public void generateFile() {
		SUBArborep subArborep = new SUBArborep();
		
		fileContent = subArborep.getContent();
		
		super.appendFile();
		
	}

}
