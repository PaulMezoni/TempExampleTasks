package TaskCodeCombat;

public class Example {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            int[] x = new int[3];
            x[i] = 1;
            for (int k : x) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
