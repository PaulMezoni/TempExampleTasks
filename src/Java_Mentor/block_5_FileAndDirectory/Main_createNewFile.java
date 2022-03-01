package Java_Mentor.block_5_FileAndDirectory;

import java.io.FileInputStream;
import java.io.IOException;

public class Main_createNewFile {

    public static void main(String[] args) throws IOException {

//        String fileSeparator = System.getProperty("file.separator");

        //создаем абсолютный путь к файлу
//        String absoluteFilePath = fileSeparator + "Users" + fileSeparator + "prologistic" + fileSeparator + "file.txt";
//        File file = new File("/Users/paulmezoni/Desktop/test");

        try (FileInputStream fin = new FileInputStream("/Users/paulmezoni/Desktop/test")) {
            System.out.printf("File size: %d bytes \n", fin.available());

            int i;
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

//        if (file.createNewFile()) {
//            System.out.println(file + " Файл создан");
//        } else {
//            System.out.println("Файл " + file + " уже существует");

//        Scanner scanner = new Scanner(file);
//        String line = scanner.nextLine();
//        String[] words = line.split(" ");
//
//        System.out.println(Arrays.toString(words));
//        scanner.close();


//        byte myByte = -18; // 11111101
//        byte[] myArray = {myByte};
//        InputStream in = new ByteArrayInputStream(myArray);
//        int myInt = in.read();
//        System.out.println(myInt); // 253

    }

}
