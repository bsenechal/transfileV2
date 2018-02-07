package com.transfile.model.log_type;

public class Sendfile extends AFileType {
	
	public Sendfile() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "sendfile.conf";
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
