package Java_Mentor.block_6_Generics;

import java.util.*;

public class MyGeneric {
    public static void main(String[] args) {
        MyGenericsClass myGenericsClass = new MyGenericsClass();
        System.out.println(myGenericsClass);

//        List<ArrayList> arrayLists = new ArrayList<ArrayList>();
//        ArrayList<List> arrayList  = new ArrayList<ArrayList>(); no work
        ArrayList<int[]> list = new ArrayList<>();
    }
}

class MyGenericsClass<T extends Number> {
    T name;
    public  void methodT(List<T> name)  {}
    public  void methodT(Queue<String> name)  {}
    public  void methodT(Set<List<String>> name)  {}
    public  void methodT(Map<Integer, Integer> name) {}
    public  void methodT(int name)  {}
    public  void methodT(Integer name)  {}

}
