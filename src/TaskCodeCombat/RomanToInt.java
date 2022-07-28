package TaskCodeCombat;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("IVV"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
    }

    public static String arabicToRoman(String numerals) {
        int num = Integer.parseInt(numerals);
        if (num <= 0) return "";
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num != 0; i++) {
            while (num >= n[i]) {
                num -= n[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static int romanToInt(String s) {
        char[] sc = s.toCharArray();
        int sum = 0;
        for (int index = sc.length - 1; index >= 0; index--) {
            if (sc[index] == 'I') {
                sum += (sum < 5 ? 1 : -1);
            } else if (sc[index] == 'V') {
                sum += 5;
            } else if (sc[index] == 'X') {
                sum += (sum < 50 ? 10 : -10);
            } else if (sc[index] == 'L') {
                sum += 50;
            } else if (sc[index] == 'C') {
                sum += (sum < 500 ? 100 : -100);
            } else if (sc[index] == 'D') {
                sum += 500;
            } else if (sc[index] == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
}
