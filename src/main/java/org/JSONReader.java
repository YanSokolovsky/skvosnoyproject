package main.java.org;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class JSONReader {
    String FileName;
    File json;
    List<expression> arr;
    Vector<String> res;
    static class expression {
        private String ex;
        String getEx() {
            return ex;
        }
        void setEx(String a) {
            ex =  a;
        }
    }
    JSONReader(String filename) {
        FileName = filename;
        json = new File(filename);
    }
    Vector<String> GetExpressions(){
        ObjectMapper obMap = new ObjectMapper();
        List<expression> exList = null;
        try {
            exList = obMap.readValue(json, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        res = new Vector();
        for (int i = 0 ; i < exList.size(); i++) {
            res.add(exList.get(i).getEx());
        }
        return res;
    }
}
