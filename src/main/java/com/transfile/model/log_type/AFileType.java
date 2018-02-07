package com.transfile.model.log_type;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public abstract class AFileType {
	protected String fileContent;
	protected String filePath;
	protected String fileName;
	private final static Logger LOGGER = Logger.getLogger(AFileType.class);
	
	public abstract void generateFile();
	
	protected void writeFile() {
		
		//Get the file reference
		Path path = Paths.get(filePath.concat(System.getProperty("file.separator")).concat(fileName));
		 
		//Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path))
		{
		    writer.write(fileContent);
		} catch (IOException e) {
			LOGGER.error("Erreur lors de l'écriture du fichier", e);
		}
	}
	
	
}
