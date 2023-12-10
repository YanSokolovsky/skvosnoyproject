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
    void WriteExpression(String result) {
        JSONoutput rt = new JSONoutput();
        rt.setRes(result);
        ObjectMapper obMap = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(JSONoutput.class, new Serializer());
        obMap.registerModule(module);
        File file = new File(name);
        try {
            obMap.writeValue(file, rt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void WriteExpression(ArrayList<String> result) {
        JSONallex rt = new JSONallex();
        rt.array = new ArrayList<>();
        for (int i = 0 ; i < result.size(); i++) {
            JSONoutput j = new JSONoutput();
            j.setRes(result.get(i));
            rt.array.add(j);
        }
        ObjectMapper obMap = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(JSONallex.class, new Serializerex());
        obMap.registerModule(module);
        File file = new File(name);
        try {
            obMap.writeValue(file, rt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
