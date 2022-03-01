package Java_Mentor.block_6_Generics;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_6_2_14 {

    /**
     * Напишите программу, которая прочитает из System.in последовательность целых чисел,
     * разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
     * и затем выведет получившуюся последовательность в обратном порядке в System.out.
     * Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
     * Все import объявлены за вас.
     * Пример ввода: 1 2 3 4 5 6 7 8 9 10
     * Пример вывода: 10 8 6 4 2
     */
    public static void main(String[] args) throws Exception {
        //  твой код здесь
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            String[] line = br.readLine().split(" ");
//            int i = line.length;
//
//            ArrayDeque<String> arrayDeque = new ArrayDeque<>();
//            for (int j = 1; j < i; ++j) {
//                if ((j & 1) != 0) {
//                    arrayDeque.addFirst(line[j]);
//                }
//            }
//            arrayDeque.forEach(e -> System.out.print(e + " "));
//        }
//    }
//}
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; scanner.hasNext(); i++) {
                if (scanner.hasNextInt() && (i % 2 != 0)) {
                    arrayDeque.addFirst(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
            arrayDeque.forEach(s -> System.out.print(s + " "));
        }
    }
}

//        try (Scanner scanner = new Scanner(System.in)) {
//            ArrayDeque deque = new ArrayDeque();
//
//            while (scanner.hasNextInt()) {
//                scanner.nextInt();
//                if (scanner.hasNextInt()) {
//                    deque.addFirst(scanner.nextInt());
//                }
//                if (!deque.isEmpty()) {
//                    System.out.print(deque.pollLast());
//                }
//                while (!deque.isEmpty()) {
//                    System.out.print(" " + deque.pollLast());
//                }
//
//                StringBuilder sb = new StringBuilder();
//                Iterator<String> iterator = deque.iterator();
//
//                try {
//                    while (iterator.hasNext()) {
//                        sb.append(iterator.next());
//                        sb.append(" ");
//                    }
//                    sb.deleteCharAt(sb.lastIndexOf(","));
//                } catch (NullPointerException e) {
//                    e.printStackTrace();
//                    System.out.print(sb.toString());
//                }
//            }
//        }
//    }
//}


/**
 * Объявляем Scanner, объявляем ArrayDeque.
 * 2. Пока(Scanner.есть_след_число()) {
 * Scanner.некст;
 * если(Scanner.есть_след_число()) {
 * ArrayDeque.addFirst(Scanner.след_число());
 * }
 * }
 * 3.  Объявляем итератор, стрингбилдер.
 * 4.  Пока(итератор.есть_след) {
 * стрингбилдер.append(итератор.след));
 * стрингбилдер.append(" "));
 * }
 * 5. Убираем последний пробел в стрингбилдере, загуглите, легко)
 * 6. System.out.println(стрингбилдер.toString());
 */