public class VigenereCipher {
    
    public static String encrypt(String text, String key) {
        text = text.toUpperCase();
        key = key.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int shift = key.charAt(i % key.length()) - 65;
                result.append((char) ((c - 65 + shift) % 26 + 65));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    
    public static String decrypt(String text, String key) {
        text = text.toUpperCase();
        key = key.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int shift = key.charAt(i % key.length()) - 'A';
                result.append((char) ((c - 'A' + 26 - shift) % 26 + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "ATTACKATDAWN";
        String key = "LEMON";
        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
