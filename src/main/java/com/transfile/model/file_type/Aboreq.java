package com.transfile.model.file_type;

import com.transfile.model.log_type.SUBAboreq;

public class Aboreq extends AFileType {
	
	public Aboreq() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "aboreq.ini";
	}
	
	@Override
	public void generateFile() {
		SUBAboreq subArboreq = new SUBAboreq();
		
		fileContent = subArboreq.getContent();
		
		super.appendFile();
		
	}

}
