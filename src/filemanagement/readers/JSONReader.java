package filemanagement.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    String FileName;
    File json;
    List<expression> arr;
    ArrayList<String> res;
    static class expression {
        private String ex;
        String getEx() {
            return ex;
        }
        void setEx(String a) {
            ex =  a;
        }
    }
    public JSONReader(String filename) {
        FileName = filename;
        json = new File(filename);
    }
    public ArrayList<String> GetExpressions(){
        ObjectMapper obMap = new ObjectMapper();
        try {
            arr = obMap.readValue(json, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        res = new ArrayList<>();
        for (int i = 0 ; i < arr.size(); i++) {
            res.add(arr.get(i).getEx());
        }
        return res;
    }
}
