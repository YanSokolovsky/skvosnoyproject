package filemanagement.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWriterNonAPI extends Writer{
    JSONWriterNonAPI(String name) {
        fileName = name;
    }
    void write(ArrayList<String> results) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write('{');
            bufferedWriter.newLine();
            bufferedWriter.write(  "  \"expressions\": [");
            bufferedWriter.newLine();
            for (String result : results) {
                bufferedWriter.write("    {");
                bufferedWriter.newLine();
                bufferedWriter.write("      \"expression\": " + result);
                bufferedWriter.newLine();
                bufferedWriter.write("    {");
            }
            bufferedWriter.newLine();
            bufferedWriter.write("  ]");
            bufferedWriter.newLine();
            bufferedWriter.write('}');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
