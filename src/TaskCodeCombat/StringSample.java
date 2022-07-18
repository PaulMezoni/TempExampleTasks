package TaskCodeCombat;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class StringSample {
    public static void main(String[] args) {

        String str = "Городской отдел ОВД 2 11.11.2008 г. 700-698";
        String last = str.substring(str.lastIndexOf(' ') + 1);
        System.out.println(last + " последний индекс ");


        String keyword = "700-698";
        boolean found = Arrays.asList(str.split(" ")).contains(keyword);
        if (found) {
            System.out.println("Keyword matched the string");
        }

        AtomicReference<StringBuilder> stringBuilder = new AtomicReference<>(new StringBuilder(str));
        stringBuilder.get().reverse();

    }
}
