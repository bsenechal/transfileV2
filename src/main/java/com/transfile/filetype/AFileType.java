/*
 *
 */
package com.transfile.filetype;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:files.properties")
public abstract class AFileType {

    private static final Logger LOGGER = Logger.getLogger(AFileType.class);
    protected static final String LINE_SEPARATOR = "line.separator";
    protected static final String FILE_SEPARATOR = "file.separator";
    protected String fileContent;
    protected String filePath;
    protected String fileName;

    protected void appendFile() {
        AFileType.LOGGER.info("Generating " + fileName);
        // Get the file reference
        final Path path = Paths.get(filePath.concat(System.getProperty(AFileType.FILE_SEPARATOR)).concat(fileName));

        // Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.append(fileContent);
        } catch (final IOException e) {
            AFileType.LOGGER.error("Erreur lors de l'écriture du fichier", e);
        }
    }

    public abstract void generateFile();

}
