import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;
public class RSAP {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
       keyGen.initialize((2048));
       KeyPair pair = keyGen.generateKeyPair();
       PublicKey pub = pair.getPublic();
       PrivateKey pri = pair.getPrivate();

       String message = "Hello RSA";

       Cipher ciphertext = Cipher.getInstance("RSA");
       ciphertext.init(Cipher.ENCRYPT_MODE, pub);
       byte[] encrypted = ciphertext.doFinal(message.getBytes());
       System.out.println(Base64.getEncoder().encodeToString(encrypted));

       Cipher decryptCipher = Cipher.getInstance("RSA");
       decryptCipher.init(Cipher.DECRYPT_MODE, pri);
       byte[] decrypted = decryptCipher.doFinal(encrypted);
       System.out.println(new String(decrypted));
        
    }
}
