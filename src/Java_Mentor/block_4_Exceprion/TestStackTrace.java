package Java_Mentor.block_4_Exceprion;

class TestStackTrace {
    TestStackTrace() {
        divideByZero();
    }

    int divideByZero() {
        return 25 / 0;
    }

    public static void main(String[] args) throws java.lang.Exception {
        try {
            new TestStackTrace();
            new Exception();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}