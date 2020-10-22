package com.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUtil {

    private static Logger log= LoggerFactory.getLogger(FileUtil.class);

    public static void moveFileToLoadedFolder(Path sourceFile , String targetDir) throws IOException {
        Path target = Paths.get(targetDir);
        if(!target.toFile().exists())
        {
            Files.createDirectories(Paths.get(targetDir));
        }
        Path targetFile = target.resolve(sourceFile.getFileName());
        Files.move(sourceFile,targetFile, StandardCopyOption.ATOMIC_MOVE);
        log.info("Files moved to loaded dir");
    }
}
