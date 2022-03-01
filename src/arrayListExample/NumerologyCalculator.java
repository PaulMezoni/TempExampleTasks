package arrayListExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NumerologyCalculator {
    static int birthday;
    static int mothOfBirth;
    static int yearOfBirth;

    public static void main(String[] args) {
//        System.out.println(lifePathNumber(25, 10, 1900) + " Pasha");
//        System.out.println(lifePathNumber(3, 6, 1992) + " Sveta");
//        System.out.println(lifePathNumber(8, 6, 1977) + " Sister");
//        System.out.println(lifePathNumber(29, 2, 1956) + " Mom");
//        System.out.println(lifePathNumber(4, 12, 1952) + " Dad");
//        System.out.println(lifePathNumber(15, 7, 1966) + " Mama Sveti");

        String str = "1234";
        List<Character> list = new LinkedList<>();
        for (char i : str.toCharArray()) {
            list.add(i);
        }
        System.out.println(list);

        ListIterator<Character> listIterator = list.listIterator();

        Character next = listIterator.next();
        System.out.println(listIterator);


        char c = '5';
        System.out.println(c + 3);
        System.out.println(3 + c);
        System.out.println("Out " + c + 3);
    }

    public static int lifePathNumber(int birthday, int mothOfBirth, int yearOfBirth) {
        List<Integer> listNumber = new ArrayList<>();
        int result = 0;

        while (birthday != 0) {
            listNumber.add(birthday % 10);
            birthday /= 10;
        }
        while (mothOfBirth != 0) {
            listNumber.add(mothOfBirth % 10);
            mothOfBirth /= 10;
        }
        while (yearOfBirth != 0) {
            listNumber.add(yearOfBirth % 10);
            yearOfBirth /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }

        listNumber.clear();
        while (result != 0) {
            listNumber.add(result % 10);
            result /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }
        listNumber.clear();
        while (result != 0) {
            listNumber.add(result % 10);
            result /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }
        return result;
    }
}


class Data {
    static int birthday;
    static int mothOfBirth;
    static int yearOfBirth;

    public Data(int birthday, int mothOfBirth, int yearOfBirth) {
        Data.birthday = birthday;
        Data.mothOfBirth = mothOfBirth;
        Data.yearOfBirth = yearOfBirth;
    }

    public void lifePathNumber() {
        List<Integer> listNumber = new LinkedList<>();
        int result = 0;

        while (birthday != 0) {
            listNumber.add(birthday % 10);
            birthday /= 10;
        }
        while (mothOfBirth != 0) {
            listNumber.add(mothOfBirth % 10);
            mothOfBirth /= 10;
        }
        while (yearOfBirth != 0) {
            listNumber.add(yearOfBirth % 10);
            yearOfBirth /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }

        listNumber.clear();
        while (result != 0) {
            listNumber.add(result % 10);
            result /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }
        listNumber.clear();
        while (result != 0) {
            listNumber.add(result % 10);
            result /= 10;
        }
        for (int num : listNumber) {
            result += num;
        }
        System.out.println(result);
    }
}

