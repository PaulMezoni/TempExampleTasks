package Stepic.exmpl.module2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main62 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        if (scanner.hasNextLine()) {
            list.add(Integer.valueOf(scanner.nextLine()));
        }
        System.out.println(list);

//        list
//                .stream().mapToInt(x -> x)
//                .filter(x -> x % 2 == 0)
//                .map(x -> Integer.parseInt(x + " ")).forEach(System.out::println);
    }
}
