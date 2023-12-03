package main.java.org;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class TXTWriter {
    String FileWriteName;
    Vector<String> Ex;
    TXTWriter(String name, Vector<String> ex) {
        FileWriteName = name;
        Ex = ex;
    }
    TXTWriter(Vector<String> ex, String name) {
        FileWriteName = name;
        Ex = ex;
    }
    void WriteExpressions(boolean append) {
        try(FileWriter writer = new FileWriter(FileWriteName, append))
        {
            for (int i = 0 ; i < Ex.size(); i++) {
                writer.append(Ex.elementAt(i));
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
