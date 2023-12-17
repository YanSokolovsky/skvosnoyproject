package main.java.org;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReaderNonAPI {
    String filename;
    XMLReaderNonAPI(String name) {
        filename = name;
    }
    ArrayList<String> GetExpressions() {
        ArrayList<String> mass = new ArrayList<>();
        Pattern parseexpre = Pattern.compile("<on>(.*)</on>");
        try {
            BufferedReader read = new BufferedReader( new FileReader(filename));
            String curr;
            while(read.ready()) {
                curr =  read.readLine();
                Matcher match = parseexpre.matcher(curr);
                if (match.find())
                    mass.add(match.group(1).toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mass;
    }
}
