package Java_Mentor.block_6_Generics;

import java.util.List;

public class Main {
public static void main(String[] args) {
   Box<Object> ints =  Box.getBox();
    System.out.println(ints);
}

public class Example<X> {
    Example<CharSequence> a = new Example<CharSequence>();
    Example<?> b = new Example<Object>();
    Example<? extends List> c = new Example<List>();
    Example d = new Example();
    Example<Object> e = new Example<Object>();
    Example<?> i = new Example<>();
}

//6_1_11
public static class Box<Type> {
    //твой код здесь
    private Type object;

    public static <T> Box<T> getBox() {

        return new Box<T>();
    }
}
}


//public class Example<X> {
//    public void someMethod(Object obj) {
//        X x1 = (X)obj;//V
//        Optional<X> x2 = Optional.empty();//V
//        boolean b1 = (obj instanceof Optional<X>);//X
//        boolean b2 = (obj instanceof X);//X
//        X x3 = new X();//X
//        X xArr[] = new X[1];//X
//    }


