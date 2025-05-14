import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        // 1. Generate Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String message = "This is a message to be signed";

        // 2. Sign with Private Key
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        byte[] signature = sign.sign();
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));

        // 3. Verify with Public Key
        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());

        boolean isVerified = verify.verify(signature);
        System.out.println("Verified: " + isVerified);
    }
}
