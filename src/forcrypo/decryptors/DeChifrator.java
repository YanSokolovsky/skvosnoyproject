package forcrypo.decryptors;

import org.apache.commons.codec.binary.Base64;

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

public class DeChifrator {
    String nameoutput;
    String nameinput;
    String key;
    DeChifrator(String name1, String name2, String k) {
        nameinput = name1;
        nameoutput = name2;
        key = k;
    }
    void dechiferfile() {
        String encryptedString = new String();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameinput));
            String t = reader.readLine();
            while (t != null) {
                encryptedString += t;
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
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        byte[] original = new byte[0];
        try {
            original = cipher.doFinal(Base64.decodeBase64(encryptedString));
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        String originalString = new String(original);
        FileWriter filewr = null;
        try {
            filewr = new FileWriter(nameoutput, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            filewr.write(originalString);
            filewr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
