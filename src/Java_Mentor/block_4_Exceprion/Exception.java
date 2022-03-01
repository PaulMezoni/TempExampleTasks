package Java_Mentor.block_4_Exceprion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//4.1.8
public class Exception extends Throwable {
    private static Object List;

    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));

            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {

            System.out.println("Ошибка! Файл не найден!");
        }
        printFirstString("down");
        


    }

    public static void printFirstString(String filePath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка, файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка при вводе/выводе данных из файла!");
            e.printStackTrace();
        }
    }
}


// 4.2.6
//    class BankClient {
//    }
//
//    interface BankWorker {
//
//    }

//    // Есть класс BankClient - это класс, описывающий клиента банка.
//// 4.2.6
//    public boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) {
//        //Твой код здесь
//        try {
//            return bankWorker.checkClientForCredit(bankClient);
//        } catch (ProblemWithLawException e) {
//            return false;
//        } catch (BadCreditHistoryException e) {
//            System.out.println("Проблемы с банковской историей");
//            return false;
//        }
//    }


