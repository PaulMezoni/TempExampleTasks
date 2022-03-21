package TaskCodeCombat;

public class SearchNumberEx {
    public static void main(String[] args) {
        System.out.println();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void searchNumber() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
