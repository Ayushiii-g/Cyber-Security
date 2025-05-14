public class RailFenceCipher {
    public static String encrypt(String text, int rails) {
        if (rails <= 1) return text;
        StringBuilder[] fence = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) fence[i] = new StringBuilder();

        int rail = 0, dir = 1;
        for (char c : text.toCharArray()) {
            fence[rail].append(c);
            rail += dir;
            if (rail == 0 || rail == rails - 1) dir *= -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : fence) result.append(row);
        return result.toString();
    }

    public static String decrypt(String cipher, int rails) {
        if (rails <= 1) return cipher;
        int len = cipher.length();
        boolean[] marker = new boolean[len];
        

        for (int r = 0; r < rails; r++) {
            int rail = 0, dir = 1;
            for (int i = 0; i < len; i++) {
                if (rail == r) marker[i] = true;
                rail += dir;
                if (rail == 0 || rail == rails - 1) dir *= -1;
            }
        }

        char[] result = new char[len];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (marker[i]) result[i] = cipher.charAt(k++);
        }

        StringBuilder finalText = new StringBuilder();
        int rail = 0, dir = 1;
        for (int i = 0; i < len; i++) {
            finalText.append(result[i]);
            rail += dir;
            if (rail == 0 || rail == rails - 1) dir *= -1;
        }
        return finalText.toString();
    }

    public static void main(String[] args) {
        String text = "HELLOWORLD";
        int rails = 3;
        String encrypted = encrypt(text, rails);
        System.out.println("Encrypted: " + encrypted);
    }
}

