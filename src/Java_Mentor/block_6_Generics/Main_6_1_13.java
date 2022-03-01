package Java_Mentor.block_6_Generics;

import java.util.Arrays;

public class Main_6_1_13 {
public static void main(String[] args) {
    DynamicArray<String> strings = new DynamicArray<>();
    strings.add("one");
    strings.add("two");
    strings.add("three");

    System.out.println("After add");
    System.out.println("the length is: " + strings.length());
    for (int i = 0; i < strings.length(); ) {
        System.out.println(strings.get(i));
    }
    System.out.println();
    strings.remove(2);
    System.out.println("After remove");
    System.out.println("the length is: " + strings.length());
    for (int i = 0; i < strings.length(); ) {
        System.out.println(strings.get(i));
    }
}

/**
 * Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
 * Создайте класс DynamicArray, который хранит в себе массив,
 * и имеет методы для добавления void add(T el),
 * void remove(int index) удаления и извлечения T get(int index) из него элементов,
 * при переполнении текущего массива, должен создаваться новый, большего размера.
 * Для возможности работы с различными классами DynamicArray должен быть дженериком.
 * Для решения задачи можно воспользоваться методами из класса java.util.Arrays.
 * Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно
 */
public static class DynamicArray<T> {
    //Реализуй класс здесь
    private int size = 0;
    //        private T[] arr = (T[]) new Object[10];
    private Object[] arr = new Object[10];

    public DynamicArray() {
    }

    public void add(T el) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size] = el;
        size++;
    }

//                public void remove(int index) {
//            System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
//        }
    public void remove(int index) {
        Object[] arrBuffer = new Object[arr.length - 1 - index];
        System.arraycopy(arr, index + 1, arrBuffer, 0, arr.length - 1 - index);
        for (int i = index; i < arr.length; i++) {
            arr[i] = null;
        }
        System.arraycopy(arrBuffer, 0, arr, index, arr.length - 1 - index);
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public int length() {
        return arr.length;
    }
}
}
//    private int size = 0;
//    private Object[] arr = new Object[10];
//    public DynamicArray() {
//    }
//    public void add(T el) {
//        if (size == arr.length) {
//            arr = Arrays.copyOf(arr, arr.length * 2);
//        }
//        arr[size] = el;
//        size++;
//    }
//    public void remove(int index) {
//        Object[] arrBuf = new Object[arr.length - 1 - index];
//        System.arraycopy(arr, index + 1, arrBuf, 0, arr.length - 1 - index);
//        for (int i = index; i < arr.length; i++) {
//            arr[i] = null;
//        }
//        System.arraycopy(arrBuf, 0, arr, index, arr.length - 1 - index);
//    }
//    public T get(int index) {
//        return (T) arr[index];
//    }
//}

//public static class DynamicArray<T> {
//    private int size = 0;
//    private T[] arr;
//    public int size() {
//        return size;
//    }
//    public int length(){
//        return arr.length;
//    }
//    public DynamicArray() {
//        arr = (T[]) new Object[size];
//    }
//    public void add(T el) {
//        arr = Arrays.copyOf(arr, arr.length + 1);
//        arr[size++] = el;
//    }
//    public void remove(int index) {
//        T[] newArr1 = (T[]) new Object[size];
//        System.arraycopy(arr, 0, newArr1, 0, index);
//        System.arraycopy(arr, index + 1, newArr1, index, arr.length - index - 1);
//        arr = newArr1;
//        size--;
//    }
//    public T get(int index) {
//        return arr[index];
//    }
//}
