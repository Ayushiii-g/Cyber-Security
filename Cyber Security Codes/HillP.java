public class HillP {
    static int[][] key = {{3, 3}, {2, 5}};
    
    static int mod26(int x){
        return (x % 26 + 26) % 26;
    }
    
    public static String encrypt(String text){
        text = text.toUpperCase().replaceAll("[^A-Z]", " ");
        if (text.length() %2 != 0){ text+= "X";}
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i+= 2){
            int[] pair = {text.charAt(i) - 65, text.charAt(i+1) - 65};
            int c1 = mod26(key[0][0] * pair[0] + key[0][1] * pair[1]);
            int c2 = mod26(key[1][0] * pair[0] + key[1][1] * pair[1]);
            result.append((char)(c1 + 65)).append((char) (c2 + 65));
        }
        
        return result.toString();
        
    }
    
    public static void main(String[] args){
        String message = "help";
        System.out.println(encrypt(message));
    }
}
