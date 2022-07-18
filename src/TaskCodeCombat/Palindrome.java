package TaskCodeCombat;

public class Palindrome {
    public static void main(String[] args) {
        String str = " ,; ;>   <aMa,mA";
        System.out.println(equalsPalindrome(str));
        System.out.println(equalsPalindrome2(str));
    }

    public static boolean equalsPalindrome(String str) {
        str = str.replaceAll("\\W", "");
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }

    static boolean equalsPalindrome2(String str) {
        str = str.replaceAll("\\W", "");
        char[] c = str.toCharArray();
        String s = "";
        for (int i = c.length - 1; i >= 0; i--) {
            s += c[i];
        }
        return str.equalsIgnoreCase(s);
    }
}
