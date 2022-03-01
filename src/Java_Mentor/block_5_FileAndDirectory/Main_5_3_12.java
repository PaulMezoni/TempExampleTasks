package Java_Mentor.block_5_FileAndDirectory;

import java.util.Scanner;
//
public class Main_5_3_12 {
    public static void main(String[] args) {
        double sum = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += Double.parseDouble(scanner.next());
                } else {
                    scanner.next();
                }
            }
            System.out.printf("%.6f", sum);
        } catch (Exception e) {
            System.out.printf("%.6f", sum);
        }
    }
}

