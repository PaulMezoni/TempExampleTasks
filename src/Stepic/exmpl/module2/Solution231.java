package Stepic.exmpl.module2;


public class Solution231 {
    public static void main(String[] args) {
        String s = "Madam, I'm Adam!";
        String s2 = "Madam, I'm Adami!";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s2));


    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        return text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
    }

    public static boolean isPalindrome1(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(text);
        String s = String.valueOf(sb.reverse());
        return s.equalsIgnoreCase(text);
    }

    public static boolean isPalindrome3(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        char[] chars = text.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            s.append(chars[i]);
        }
        return s.toString().equalsIgnoreCase(text);
    }
}
