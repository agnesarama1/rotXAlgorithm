import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionExample {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String ROTX_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedMessage, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes, "UTF-8");
    }

    public static String rotXEncrypt(String message, int rotX) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (ROTX_ALPHABET.indexOf(c) >= 0) {
                int index = (ROTX_ALPHABET.indexOf(c) + rotX) % ROTX_ALPHABET.length();
                result.append(ROTX_ALPHABET.charAt(index));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

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


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the message: ");
        String message = scanner.nextLine();
        String secretKey;
        while (true) {
            System.out.print("Input the length of the key (16, 24, or 32): ");
            secretKey = scanner.nextLine();
            if (secretKey.equals("16") || secretKey.equals("24") || secretKey.equals("32")) {
                break;
            }
            System.out.println("Invalid key length. Key length must be 16, 24, or 32. ");
        }

        byte[] keyBytes = new byte[Integer.parseInt(secretKey)];
        Key key = new SecretKeySpec(keyBytes, "AES");

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        while (true) {
            System.out.print("Do you want to display the decrypted message? (Y/N): ");
            String choice = scanner.nextLine();
            // Check if the user entered "Y" or "N"
            if (choice.equalsIgnoreCase("Y")) {
                String decryptedMessage = decrypt(encryptedMessage, key);
                System.out.println("Decrypted message: " + decryptedMessage);
                break; // Exit the loop if a valid value is entered
            } else if (choice.equalsIgnoreCase("N")) {
                break; // Exit the loop if a valid value is entered
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }

        }
    }

    int rotX;
    while(true)

    {
        System.out.println("Enter the rotation factor X:");
        String input = scanner.nextLine();
        try {
            rotX = Integer.parseInt(input);
            break;
        }
        catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid integer for the rotation factor.");
        }
    }
    
}