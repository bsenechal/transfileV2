package com.transfile.model.log_type;

public class Requete extends AFileType {
	
	public Requete() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "requete.conf";
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
