package Example;

import arrayListExample.Person;
import arrayListExample.ReportCard;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;

public class Test extends ReportCard {
    protected Test(int currentDepth, String name) {
        super(currentDepth);
    }

    ReportCard reportCard = new ReportCard(20);

    public static void main(String[] args) {

        MessageFormat ms = new MessageFormat("MD5");


//        Optional<String> optionalS = Optional.empty();
//        System.out.println(optionalS.isEmpty());
//        System.out.println(optionalS.isPresent());

        Collection<Integer> arr = Arrays.asList(4, 1, 6, 3, 2, 5, 7, 9, 8, 6, 10, 1, 2, 3, 5, 6, 2, 3, 20, 11, 15, 20);

        int[] a = {1, 1, 2}; // 10 цифр, 3 числа повторяются и их нужно удалить
        int target = 6;
        int[] b = new int[0];
        int y = 1;
        int x = 1;
//        System.out.println(y == x);
        System.out.println(removeDuplicates(a) + " remove duplicates");
        System.out.println(removeDuplicates(b) + " remove duplicates");
        System.out.println(search(a, 3) + " search element");

        Person p1 = new Person("Vasa");
        Person p2 = new Person("Vasa");
        System.out.println(p1.equals(p2));
        System.out.println(p1 == (p2));

//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(123));


//        sum(a);
//        array(b);
//        number(a, x);

//        String[] s = {"Regulus", "Regard", "Max", "Курва", "МАГНУЛЮС", "123", "1", "]["};
//        bubbleSort(s);
//        System.out.println(determineAdult(-1));
//        System.out.println(determineAdult(18));


    }


    public static int search(int[] a, int searchElement) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == searchElement) {
                return searchElement;
            }
        }
        return -1;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static boolean determineAdult(int age) {
        //Твой код здесь
        final int name;
        if (age >= 18) {
            return true;
        } else if (age < 18 && age >= 0) {
            return false;
        }
        if (age < 0) {
            System.out.println("Ошибка! Введите правильный возраст.");
            return false;
        }
        return false;
    }

    boolean isPalindrome(int x) {
        String s1 = String.valueOf(x);
        return s1.equals(new StringBuilder(s1).reverse().toString());
    }

    class Solution {
        public int romanToInt(String s) {
            switch (s) {
//                case 'I' -> System.out.println(1);
            }
            return 0;
        }

    }

    public static char charExpression(int a) {
        return (char) ((int) '\\' + a);
    }

    static void number(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                continue;
            }
            System.out.print(array[i] + " ");
        }
    }

    static void bubbleSort(String[] i) {
        for (int j = 0; j < i.length - 1; j++) {
            for (int k = j; k < i.length; k++) {
                if (i[j].compareTo(i[k]) > 0) {
                    String tmp = i[j];
                    i[j] = i[k];
                    i[k] = tmp;
                }
            }
            System.out.print(i[j] + " ");
        }
    }

    public static void originalIntFirst(int[] test) {
        for (int i = 0; i < test.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < test.length; j++) {
                if (test[i] == test[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(test[i]);
                break;
            }
        }
    }

    public static void array(int[] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i] = 1;
                System.out.print(array[j] + " ");
                array[i] = 0;
            }
            System.out.println();
        }
    }

    public void sum(int[] a) {
        int s = 0;
        for (int j : a) {
            s += j;
            System.out.print(s + " ");
        }
        System.out.println("\n" + s + " ");
    }
}


