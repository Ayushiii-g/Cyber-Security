import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        // 1. Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey pubKey = pair.getPublic();
        PrivateKey privKey = pair.getPrivate();

        String message = "Hello RSA";

        // 2. Encrypt with Public Key
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encrypted = encryptCipher.doFinal(message.getBytes());

        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // 3. Decrypt with Private Key
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privKey);
        byte[] decrypted = decryptCipher.doFinal(encrypted);

        System.out.println("Decrypted: " + new String(decrypted));
    }
}

