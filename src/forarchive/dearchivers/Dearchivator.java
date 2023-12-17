package forarchive.dearchivers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Dearchivator {
    String archFile;
    public String getOutputFile() {
        return archFile;
    }

    public void setOutputFile(String outputFile) {
        this.archFile = outputFile;
    }
    String getShortName(String fileName) {
        String expression = "[^\\\\]*$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return fileName.substring(matcher.start(), matcher.end());
        } else {
            return "ERROR";
        }
    }
    abstract ArrayList<String> dearchive();
    abstract ArrayList<String> dearchive(String fileDestination);
}
