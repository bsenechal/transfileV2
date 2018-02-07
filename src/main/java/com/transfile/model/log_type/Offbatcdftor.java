package com.transfile.model.log_type;

public class Offbatcdftor extends AFileType {
	
	public Offbatcdftor() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "offbatcdftor.conf";
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
