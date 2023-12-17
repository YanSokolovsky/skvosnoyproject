package forarchive.archivers;

import java.io.IOException;
import java.util.ArrayList;

public class RarArch {
    ArrayList<String> filename;
    RarArch(ArrayList<String> name) {
        filename = name;
    }
    void DeArchvize(String nameofrar) {
        try {
            for (int i = 0 ; i < filename.size(); i++) {
                String sourceFile = filename.get(i);
                String rarFile = nameofrar;
                String winrarPath = "D:\\WinRAR.exe";
                String command = String.format("\"%s\" a -ep1 \"%s\" \"%s\"", winrarPath, rarFile, sourceFile);
                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
