package com.transfile.file_type;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:path.properties")
public abstract class AFileType {

    private final static Logger LOGGER = Logger.getLogger(AFileType.class);
    protected String fileContent;

    @Value("${output.path}")
    protected String filePath;
    protected String fileName;

    protected void appendFile() {

        // Get the file reference
        final Path path = Paths.get(filePath.concat(System.getProperty("file.separator")).concat(fileName));

        // Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(fileContent);
        } catch (final IOException e) {
            AFileType.LOGGER.error("Erreur lors de l'écriture du fichier", e);
        }
    }

    public abstract void generateFile();
}
