package TaskCodeCombat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParseString {
    public static void main(String[] args) {
        String test = "Россия, 123308, край Забайкальский, р-н Шилкинский, пгт Первомайский, ул. Шилова, д. 19";
//        String[] s = test.split("[ ,]+");

        System.out.println(multiply("2", "3"));
        System.out.println(multiply("20", "30"));
        System.out.println(multiply("212", "332"));
        System.out.println(multiply("123456789", "987654321"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);

        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else
                result += map.get(s.charAt(i));
        }
        return result;
    }

    // не использовать BigDecimal
    public static String multiply(String num1, String num2) {
        BigDecimal x1 = BigDecimal.valueOf(Long.parseLong(num1));
        BigDecimal x2 = BigDecimal.valueOf(Long.parseLong(num2));
        BigDecimal x3 = x1.multiply(x2);
        return String.valueOf(x3);
    }

}
