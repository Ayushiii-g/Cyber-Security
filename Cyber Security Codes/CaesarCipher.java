public class CaesarCipher{
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isUpperCase(character)) {
                result.append((char) ((character + shift - 65) % 26 + 65));
            } else if (Character.isLowerCase(character)) {
                result.append((char) ((character + shift - 97) % 26 + 97));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // Caesar decryption is reverse shift
    }

    public static void main(String[] args) {
        String plain = "HelloWorld";
        int shift = 3;
        String encrypted = encrypt(plain, shift);
        String decrypted = decrypt(encrypted, shift);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}