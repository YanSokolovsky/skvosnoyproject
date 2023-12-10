package main.java.org;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDearch {
    String filename;
    ZipDearch(String name) {
        filename = name;
    }
    ArrayList<String> DeArchvize() {
        ArrayList<String> names = new ArrayList<>();
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(filename)))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName();
                names.add(name);
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
            zin.close();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return names;
    }
}
