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

import com.transfile.stats.StatsException;

@PropertySource("classpath:files.properties")
public abstract class AFileType {

    private static final Logger LOGGER = Logger.getLogger(AFileType.class);
    protected static final String LINE_SEPARATOR = "line.separator";
    protected static final String FILE_SEPARATOR = "file.separator";
    protected String filePath;
    protected String fileName;
    protected StringBuilder content = new StringBuilder();

    protected abstract void generateContent() throws StatsException;

    public void generateFile() {
        AFileType.LOGGER.info("Generating " + fileName);

        // Get the file reference
        final Path path = Paths.get(filePath.concat(System.getProperty(AFileType.FILE_SEPARATOR)).concat(fileName));

        // Use try-with-resource to get auto-closeable writer instance
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            this.generateContent();

            writer.append(content);
        } catch (final IOException e) {
            AFileType.LOGGER.error("Error while writing " + fileName, e);
        }
        catch (final StatsException e) {
            AFileType.LOGGER.error(e);
        }
    }

}
