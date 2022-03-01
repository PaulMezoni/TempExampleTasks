package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExampleExceptions  {
    public static void main(String[] args) {
        Exception ex = twoExceptionsMethod();
        System.out.println(ex.getClass());

        String s = twoExceptionsMethod2();
        System.out.println(s);

        String s2 = String.valueOf(ioExcAndFileNotFoundEx());
        System.out.println(s2);
    }

    public static Exception twoExceptionsMethod() {
        try {
            return new IndexOutOfBoundsException();
        } finally {
            return new NullPointerException();
        }
    }

    public static String twoExceptionsMethod2() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() + " catchBlock");
            ;
        } finally {
            Exception ex2 = new Exception();
            return ex2.getMessage() + " finallyBlock";
        }
    }

    public static boolean ioExcAndFileNotFoundEx() {
        try {
            //TODO: some code
            String x = "abc";
            if (x.equals("abc")) {
                throw new IOException();
            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
