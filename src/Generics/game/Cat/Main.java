package Generics.game.Cat;

public class Main {

    public static void main(String[] args) {
        Scottish scottish = new Scottish(12, "Curzio", "Max");
        Scottish scottish1 = new Scottish(12, "Curzio", "Max");
        System.out.println(scottish.equals(scottish1));
        System.out.println(scottish == (scottish1));
    }
}
