package com.transfile.model.log_type;

public class Aboreq extends AFileType {
	
	public Aboreq() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "aboreq.ini";
	}
	
	@Override
	public void generateFile() {
		// TODO Auto-generated method stub
		
		// Client.findBy ...
		
		// Configuration.findBy ...
		
		// Normalisation
		
		fileContent = "test";
		
		super.writeFile();
		
	}

}