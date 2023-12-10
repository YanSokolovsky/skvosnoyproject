package main.java.org;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Chifrator {
    String nameoutput;
    String nameinput;
    String key;
    Chifrator(String name1, String name2, String k) {
        nameinput = name1;
        nameoutput = name2;
        key = k;
    }
    void chiferfile() {
        String notc = new String();
        String c = new String();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameinput));
            String t = reader.readLine();
            while (t != null) {
                notc += t;
                t = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        byte[] encrypted = new byte[0];
        try {
            encrypted = cipher.doFinal(notc.getBytes());
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        c = Base64.getEncoder().encodeToString(encrypted);
        try {
            FileWriter filewr = new FileWriter(nameoutput, false);
            filewr.write(c);
            filewr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
