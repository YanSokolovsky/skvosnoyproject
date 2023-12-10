package main.java.org;

import com.github.junrar.Junrar;
import com.github.junrar.exception.RarException;

import java.io.File;
import java.io.IOException;

public class RarDearch {
    String name;
    RarDearch(String filename) {
        name = filename;
    }
    void DeArchvize(String destfile) {
        File rarFile = new File(name);
        File destDir = new File(destfile);
        try {
            Junrar.extract(rarFile, destDir);
        } catch (IOException | RarException e) {
            e.printStackTrace();
        }
    }
}
