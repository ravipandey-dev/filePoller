package com.test.listner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileListner {

    @Value("${input.dir}")
    String inputdir;
    @Value("${loaded.dir}")
    String loadeddir;

    private static Logger log= LoggerFactory.getLogger(FileListner.class);
    @PostConstruct
    public void init() throws IOException {
        log.info("Creating Directories");
        Files.createDirectories(Paths.get(inputdir));
        Files.createDirectories(Paths.get(loadeddir));
        log.info("Directories created");
    }
}
