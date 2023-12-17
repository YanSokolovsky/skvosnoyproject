package forarchive.dearchivers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDearchivator extends Dearchivator {
    ZipDearchivator(String name) {
        archFile = name;
    }
    @Override
    ArrayList<String> dearchive() {
        ArrayList<String> names = new ArrayList<>();
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archFile)))
        {
            ZipEntry entry;
            String name;
            while((entry = zipInputStream.getNextEntry())!=null){
                name = entry.getName();
                names.add(name);
                FileOutputStream fileOutputStream = new FileOutputStream(name);
                for (int c = zipInputStream.read(); c != -1; c = zipInputStream.read()) {
                    fileOutputStream.write(c);
                }
                fileOutputStream.flush();
                zipInputStream.closeEntry();
                fileOutputStream.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return names;
    }
    @Override
    ArrayList<String> dearchive(String fileDestination) {
        return new ArrayList<>();
    }
}
