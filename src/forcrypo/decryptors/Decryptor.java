package forcrypo.decryptors;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Decryptor extends Decoder{
    String File;

    Decryptor(String inputName, String key) {
        File = inputName;
        this.Key = key;
    }
    @Override
    void decryptFile() {
        try {
            if (!isDecoded(File)) {
                File oldfile = new File(File);
                FileInputStream ins = new FileInputStream(File);
                String shortname = getShortName(File);
                byte[] decryptedBytesOfName;
                byte[] encryptedBytes;
                byte[] decryptedBytes;
                encryptedBytes = ins.readAllBytes();
                SecretKeySpec keySpec = new SecretKeySpec(Key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
                decryptedBytes = cipher.doFinal(encryptedBytes);
                decryptedBytesOfName = cipher.doFinal(Base64.decodeBase64(shortname));
                String address = getAddressOfFile(File);
                address += "\\";
                String normalName = address + new String(decryptedBytesOfName);
                File newfile = new File(normalName);
                oldfile.renameTo(newfile);
                ins.close();
                FileOutputStream outs = new FileOutputStream(normalName);
                outs.write(decryptedBytes);
                outs.close();
                ins.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
