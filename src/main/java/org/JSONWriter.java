package main.java.org;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONWriter {
    String name;
    static class res {
        private String re;
        String getRes() {
            return re;
        }
        void setRes(String a) {
            re = a;
        }
    }
    JSONWriter() {
        name = "D:\\output.json";
    }
    JSONWriter(String n) {
        name = n;
    }
    void WriteExpressions(String result) {
        res r = new res();
        r.setRes(result);
        ObjectMapper obMap = new ObjectMapper();
        File file = new File(name);
        try {
            obMap.writeValue(file, r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
