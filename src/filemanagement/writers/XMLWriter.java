package filemanagement.writers;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import filemanagement.ex;
import filemanagement.one;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLWriter {
    String filename;
    public XMLWriter(String name) {
        filename = name;
    }
    void WriteExpression(String result) throws IOException {
        XmlMapper Map = new XmlMapper();
        File file = new File(filename);
        one ob = new one();
        ob.on = result;
        Map.writerWithDefaultPrettyPrinter().writeValue(file, ob);
    }
    public void WriteExpression(ArrayList<String> result) throws IOException {
        XmlMapper Map = new XmlMapper();
        Map.registerModule(new SimpleModule().addSerializer(ex.class, new xmlserialiser()));
        File file = new File(filename);
        ex gt = new ex();
        gt.expre = new ArrayList<>();
        for (int i = 0 ; i < result.size(); i++) {
            one h = new one();
            h.on = result.get(i);
            gt.expre.add(h);
        }
        Map.writerWithDefaultPrettyPrinter().writeValue(file, gt);
    }
}
