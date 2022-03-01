package arrayListExample;

public class ReportCard {
    /**
     * Mетод convertGrades принимает один целочисленный аргумент - результат теста
     * и возвращает символ A, B, C or D в зависимости от этого аргумента.
     */
    int currentDepth;

    public ReportCard(int currentDepth) {
        this.currentDepth = currentDepth;
    }

    private char convertGrades(int testResult) {
        char grade;
        if (testResult >= 90) {
            grade = 'A';
        } else if (testResult >= 80 && testResult < 90) {
            grade = 'B';
        } else if (testResult >= 70 && testResult < 80) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        return grade;

    }

    public static void main(String[] args) {

        String[] players = new String[3];
        players[0] = "David";
        players[1] = "Max";
        players[2] = "Sam";

        int counter = 0;
        while (counter < players.length) {
            String play = players[counter];
//            System.out.print(play + " ");

            if (play.equals("Max")) {
                counter++;
            }
            System.out.print(play + " ");
        }
        System.out.println();

        ReportCard reportCard = new ReportCard(20);

        int yourGrade = 0;
        switch (yourGrade) {
            case 'A' -> System.out.println("Превосходная работа!");
            case 'B' -> System.out.println("Хорошая работа!");
            case 'C' -> System.out.println("Надо подтянуть знания!");
            case 'D' -> System.out.println("Будь посерьёзнее!");
        }

        System.out.println(yourGrade = reportCard.convertGrades(91));
    }
}