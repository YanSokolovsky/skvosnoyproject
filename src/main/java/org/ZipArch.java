package main.java.org;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArch {
        ArrayList<String> fileNames;
        //ArrayList<Boolean> fileAdded;
    ZipArch(ArrayList<String> names) {
        fileNames = new ArrayList<>();
        for (int i = 0 ; i < names.size(); i++) {
            fileNames.add(names.get(i));
        }
        //can be implement smart adding
    }
    void Archvize(String name) {
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(name)))
        {
            for (int i = 0 ; i < fileNames.size(); i++) {
                FileInputStream fis = new FileInputStream(fileNames.get(i));
                ZipEntry entry = new ZipEntry(fileNames.get(i));
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
            zout.close();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
