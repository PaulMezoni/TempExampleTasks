package Calculator;

import java.util.Scanner;

public class ExampleCalc {
    public static void main(String[] args) {
        System.out.println("введите");
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y;
        int str = scanner.nextInt(x);
        System.out.println(str);


    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
