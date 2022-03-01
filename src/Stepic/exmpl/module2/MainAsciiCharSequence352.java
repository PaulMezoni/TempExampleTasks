package Stepic.exmpl.module2;

public class MainAsciiCharSequence352 {

    public static void main(String[] args) {
        byte[] x = new byte[]{65, 66, 67, 68, 69, 70, 71};
        AsciiCharSequence myX = new AsciiCharSequence(x);
        System.out.println(myX.length());
        System.out.println(myX.charAt(3));
        System.out.println(myX.subSequence(3, 5));
        System.out.println(myX);


    }

}
