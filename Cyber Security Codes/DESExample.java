import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class DESExample {
    public static void main(String[] args) throws Exception {
        // 1. Generate DES key
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGen.generateKey();

        String message = "DES Encryption";

        // 2. Encrypt
        Cipher encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = encryptCipher.doFinal(message.getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // 3. Decrypt
        Cipher decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = decryptCipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
