package TaskCodeCombat;

import java.util.Arrays;
import java.util.Objects;

public class TestEx {
    String name;
    public TestEx(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestEx testEx)) return false;
        return Objects.equals(name, testEx.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    static void test(int num) {
        System.out.println("до увеличения " + num); // копия
        num += 1; // пробуем увеличить на 1
        System.out.println("после увеличения " + num);
    }

    static void test2(int[] arr) {
        System.out.println(Arrays.toString(arr));
        arr[0] = 777; // меняем значение 1го элемента в массиве

//        arr = arr2;//указываем ссылкой на другой массив
        System.out.println(Arrays.toString(arr)); // вывод [0]

    }

    static int[] test3(int[] arr) {
        return new int[]{arr[0] = 333};
    }

    static final int a = 1;
    static final int[] b = {1, 2, 3};

    public static void main(String[] args) {

        System.out.println(a);
        test(a);
        System.out.println(a);

        System.out.println();


        System.out.println(Arrays.toString(b));
        test2(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(test3(b)) + Arrays.toString(b));
    }
}

