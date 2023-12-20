package forcrypo.decryptors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Decoder {
    String Key;
    String dellitingSlashes(String fileName) {
        String expression = "\\+$";
        fileName = fileName.replaceAll(expression, "");
        return fileName;
    }
    String getAddressOfFile(String fileName) {
        String expression = "[^\\\\]*$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(fileName);
        String address;
        if (matcher.find()) {
            address = fileName.substring(0, matcher.start());
        } else {
            address = fileName;
        }
        address = dellitingSlashes(address);
        return address;
    }
    String getShortName(String fileName) {
        fileName = dellitingSlashes(fileName);
        String expression = "[^\\\\]*$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            return fileName.substring(matcher.start(), matcher.end());
        } else {
            return fileName;
        }
    }
    boolean isDecoded(String fileName) {
        Pattern pattern = Pattern.compile("[^.]+$");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            String format = fileName.substring(matcher.start(), matcher.end());
            return switch (format) {
                case "json", "txt", "zip", "rar", "Rar", "RAR", "Zip", "ZIP", "xml", "pdf" -> true;
                default -> false;
            };
        } else {
            return false;
        }
    }
    abstract void decryptFile();
}
