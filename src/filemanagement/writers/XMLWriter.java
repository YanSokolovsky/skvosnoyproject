package filemanagement.writers;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter extends Writer{
    public XMLWriter(String name) {
        fileName = name;
    }
    @Override
    void write(ArrayList<String> results) {
        XmlMapper Map = new XmlMapper();
        Map.registerModule(new SimpleModule().addSerializer(Writer.data.class, new XMLSerializer()));
        File file = new File(fileName);
        data Data = new data();
        for (String s : results) {
            text t = new text();
            t.expression = s;
            Data.expressions.add(t);
        }
        try {
            Map.writerWithDefaultPrettyPrinter().writeValue(file, Data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
