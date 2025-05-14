import java.security.*;
import javax.crypto.*;
import java.util.Base64;
public class RSAPP {
    public static void main(String[] args) throws Exception{
        KeyPairGenerator keyGen =KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey pub = pair.getPublic();
        PrivateKey pri = pair.getPrivate();
        
        String message = "RSA Example";
        
        Cipher ciphertext = Cipher.getInstance("RSA");
        ciphertext.init(Cipher.ENCRYPT_MODE, pub);
        byte[] encrypted = ciphertext.doFinal(message.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(encrypted));
        
        Cipher plaintext = Cipher.getInstance("RSA");
        plaintext.init(Cipher.DECRYPT_MODE, pri);
        byte[] decrypted = plaintext.doFinal(encrypted);
        System.out.println(new String(decrypted));
    }
}
