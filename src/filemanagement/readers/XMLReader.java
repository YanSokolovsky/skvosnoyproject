package filemanagement.readers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filemanagement.writers.ex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLReader {
    String filename;
    public XMLReader(String name)
    {
        filename = name;
    }
    public ArrayList<String> GetExpressions() {
        XmlMapper obMap = new XmlMapper();

        ex expressions;
            try {
                expressions = obMap.readValue(new File(filename), ex.class);
                ArrayList<String> ar = new ArrayList<>();
                for (int i = 0 ; i < expressions.expre.size(); i++) {
                    ar.add(expressions.expre.get(i).on);
                }
                return ar;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
