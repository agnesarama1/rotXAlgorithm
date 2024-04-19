import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionExample {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String ROTX_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static  String encrypt(String message,  Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static  String decrypt(String encryptedMessage, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, "UTF-8");
    }

    public static String rotXEncrypt (String message, int rotX){
        StringBuilder result= new StringBuilder ();
        for (char c: message.toCharArray()) {
            if (ROTX_ALPHABET.indexof(c)>=0){
                int index = (ROTX_ALPHABET.indexof(c)+ rotX) % ROTX_ALPHABET.length();
                result.append(ROTX_ALPHABET.charAt(index));
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
        public static String rotXDecrypt(String encryptedMessage, int rotX) {
        StringBuilder result = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            if (ROTX_ALPHABET.indexOf(c) >= 0) {
                int index = (ROTX_ALPHABET.indexOf(c) - rotX + ROTX_ALPHABET.length()) % ROTX_ALPHABET.length();
                result.append(ROTX_ALPHABET.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
        

}
