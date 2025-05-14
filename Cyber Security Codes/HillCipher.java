public class HillCipher {
    static int[][] keyMatrix = {{3, 3}, {2, 5}};

    static int mod26(int x) {
        return (x % 26 + 26) % 26;
    }

    public static String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        if (plaintext.length() % 2 != 0) plaintext += "X";

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            int[] pair = {plaintext.charAt(i) - 65, plaintext.charAt(i + 1) - 65};
            int c1 = mod26(keyMatrix[0][0] * pair[0] + keyMatrix[0][1] * pair[1]);
            int c2 = mod26(keyMatrix[1][0] * pair[0] + keyMatrix[1][1] * pair[1]);
            ciphertext.append((char) (c1 + 'A'));
            ciphertext.append((char) (c2 + 'A'));
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "HELP";
        String encrypted = encrypt(plaintext);
        System.out.println("Encrypted: " + encrypted);
    }
}
