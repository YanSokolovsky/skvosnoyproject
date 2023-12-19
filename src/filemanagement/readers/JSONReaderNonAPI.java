package filemanagement.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONReaderNonAPI extends Reader{
    public JSONReaderNonAPI(String name) {
        fileName = name;
    }
    @Override
    public ArrayList<String> read() {
        ArrayList<String> mass = new ArrayList<>();
        Pattern parseexpre = Pattern.compile("\"expression\" : \"(.*)\"");
        try {
            BufferedReader read = new BufferedReader( new FileReader(fileName));
            String curr;
            while(read.ready()) {
                curr =  read.readLine();
                Matcher match = parseexpre.matcher(curr);
                if (match.find())
                    mass.add(match.group(1));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mass;
    }
}
