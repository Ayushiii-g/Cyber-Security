import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayfairCipher {
    private static char[][] matrix = new char[5][5];
    private static String key;

    public static void generateMatrix(String keyInput) {
        key = keyInput.toUpperCase().replaceAll("J", "I").replaceAll("[^A-Z]", "");
        Set<Character> used = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : key.toCharArray()) {
            if (used.add(c)) sb.append(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J' && used.add(c)) sb.append(c);
        }

        for (int i = 0; i < 25; i++) {
            matrix[i / 5][i % 5] = sb.charAt(i);
        }
    }

    private static String[] formDigraphs(String text) {
        text = text.toUpperCase().replaceAll("J", "I").replaceAll("[^A-Z]", "");
        List<String> digraphs = new ArrayList<>();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';
            if (a == b) {
                digraphs.add("" + a + 'X');
                i--;
            } else {
                digraphs.add("" + a + b);
            }
        }
        return digraphs.toArray(new String[0]);
    }

    private static int[] find(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    public static String encrypt(String plaintext) {
        StringBuilder result = new StringBuilder();
        for (String pair : formDigraphs(plaintext)) {
            int[] a = find(pair.charAt(0));
            int[] b = find(pair.charAt(1));

            if (a[0] == b[0]) {
                result.append(matrix[a[0]][(a[1] + 1) % 5]);
                result.append(matrix[b[0]][(b[1] + 1) % 5]);
            } else if (a[1] == b[1]) {
                result.append(matrix[(a[0] + 1) % 5][a[1]]);
                result.append(matrix[(b[0] + 1) % 5][b[1]]);
            } else {
                result.append(matrix[a[0]][b[1]]);
                result.append(matrix[b[0]][a[1]]);
            }
        }
        return result.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder result = new StringBuilder();
        for (String pair : formDigraphs(ciphertext)) {
            int[] a = find(pair.charAt(0));
            int[] b = find(pair.charAt(1));

            if (a[0] == b[0]) {
                result.append(matrix[a[0]][(a[1] + 4) % 5]);
                result.append(matrix[b[0]][(b[1] + 4) % 5]);
            } else if (a[1] == b[1]) {
                result.append(matrix[(a[0] + 4) % 5][a[1]]);
                result.append(matrix[(b[0] + 4) % 5][b[1]]);
            } else {
                result.append(matrix[a[0]][b[1]]);
                result.append(matrix[b[0]][a[1]]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        generateMatrix("keyword");
        String plaintext = "hide the gold";
        String encrypted = encrypt(plaintext);
        String decrypted = decrypt(encrypted);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
