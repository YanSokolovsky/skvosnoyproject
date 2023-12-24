package UsersInterfaces;

import java.io.File;
import java.util.ArrayList;

public class CLI {
    // command "cd filename"
    // command "encode filename"
    // command "decode filename"
    // command "addtoarch filename"
    // command "cleartoarch"
    // command "rar rarfile"
    // command "zip zipfile"
    // command "dezip zipfile"
    // command "derar rarfile"
    // command "read filename\s(normal file)"
    // command "calculate"
    // command "write"
    boolean isExist(String fileName) {
        ArrayList<String> files = getListOfFiles();
        return files.contains(currPath + "\\" + fileName);
    }
    String currPath;
    ArrayList<String> getListOfFiles() {
        File folder = new File(currPath);
        File[] files = folder.listFiles();
        ArrayList<String> ListOfNames = new ArrayList<>();
        if (files == null) {
            return null;
        } else {
            for (File file : files) {
                ListOfNames.add(file.getName());
            }
        }
        return ListOfNames;
    }

}
