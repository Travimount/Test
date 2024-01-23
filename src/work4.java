import java.util.HashMap;
import java.util.Map;

public class work4{
    private static Map<Character, Character> encryptionMap = new HashMap<>();
    private static Map<Character, Character> decryptionMap = new HashMap<>();

    static {
        //加密表
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shuffled = "BCDEFGHIJKLMNOPQRSTUVWXYZAzyxwvutsrqponmlkjihgfedcba";
        for (int i = 0; i < alphabet.length(); i++) {
            encryptionMap.put(alphabet.charAt(i), shuffled.charAt(i));
            decryptionMap.put(shuffled.charAt(i), alphabet.charAt(i));
        }
    }

    public static String encrypt(String text) {
        return transform(text, encryptionMap);
    }

    public static String decrypt(String text) {
        return transform(text, decryptionMap);
    }

    private static String transform(String text, Map<Character, Character> map) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(map.getOrDefault(c, c));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String originalText = "Hello, World!";
        String encrypted = encrypt(originalText);
        String decrypted = decrypt(encrypted);

        System.out.println("源字符串: " + originalText);
        System.out.println("加密后的字符串: " + encrypted);
        System.out.println("解密后的字符串: " + decrypted);
    }
}
