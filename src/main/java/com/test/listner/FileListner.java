package com.test.listner;


import com.test.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.*;

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

    @Scheduled(fixedDelayString = "${polling.delay}")
    public void listen()
    {
        log.info("Listening for files");
        try(DirectoryStream<Path> stream =Files.newDirectoryStream(Paths.get(inputdir)))
        {
            for(Path path:stream)
            {
                if(!path.toFile().isDirectory())
                {
                    log.info("Files found , started moving");
                    FileUtil.moveFileToLoadedFolder(path.toAbsolutePath(),loadeddir);
                }
            }

        } catch (IOException e) {
           log.error("Exception caught ",e);
        }

    }


}
