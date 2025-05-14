public class VigenereP {
    public static String encrypt(String text, String key){
        text = text.toUpperCase();
        key = key.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (Character.isLetter(c)){
                int shift = key.charAt(i % key.length()) - 65;
                result.append((char)((c + shift - 65)% 26 + 65));
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
    
    public static String decrypt(String text, String key){
        text = text.toUpperCase();
        key = key.toUpperCase();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (Character.isLetter(c)){
                int shift = key.charAt(i % key.length()) - 65;
                result.append((char)((c - 65 + 26 - shift)% 26 + 65));
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args){
        String text = "ATTACKATDAWN";
        String key = "LEMON";
        System.out.println(encrypt(text, key));
        System.out.println(decrypt(encrypt(text, key), key));
    }
}
