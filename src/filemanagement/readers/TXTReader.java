package filemanagement.readers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class TXTReader<in> {
    String FileInputName;
    Vector<String> Ex;
    TXTReader(String Input) {
        FileInputName = Input;
        Ex = new Vector<>();

    }
    Vector<String> GetExpretions() {
        String set;
        Vector<String> vec = new Vector();
        StringBuilder temp = new StringBuilder();
        try(FileReader in = new FileReader(FileInputName)) {
            int w = in.read();
            while (w != -1) {
                if (w == (int) '\n' && !temp.isEmpty()) {
                    vec.add(temp.toString());
                    temp = new StringBuilder();
                } else {
                    temp.append((char) w);
                }
                w = in.read();
            }
            vec.add(temp.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return vec;
    }
}
