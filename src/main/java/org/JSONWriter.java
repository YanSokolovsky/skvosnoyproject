package main.java.org;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWriter {
    String name;
    JSONWriter() {
        name = "D:\\output.json";
    }
    JSONWriter(String n) {
        name = n;
    }
    void WriteExpressions(String result) {
        JSONallex r = new JSONallex();
        JSONoutput rt = new JSONoutput();
        JSONoutput rt1 = new JSONoutput();
        rt1.setRes(result);
        r.array = new ArrayList<>();
        r.array.add(rt1);
        rt.setRes(result);
        r.array.add(rt);
        ObjectMapper obMap = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(JSONallex.class, new Serializer());
        obMap.registerModule(module);
        File file = new File(name);
        try {
            obMap.writeValue(file, r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
