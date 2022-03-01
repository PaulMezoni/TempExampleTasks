package Java_Mentor.block_5_FileAndDirectory;

import java.io.File;

/**
 * Created by kvu on 17.08.2017.
 * <p>
 * stepik-Java-5-1-7
 * код к решению задачи: Найдите среди приведенных путей два эквивалентных, то есть указывающих на один и тот же файл.
 */
public class PathTesting {
    public static void main(String[] args) {
        String[] arr = new String[]{
                "a//b//..//file.txt",
                "a////b////c////file.txt",
                "a////..////b////c////file.txt",
                "a////.////b////..////c////.////file.txt",
                ".////a////b////..////b////c////.////file.txt"};

        for (String st : arr) {
            File file_temp = new File(st);
            System.out.println(st);
            try {
                System.out.println(file_temp.getCanonicalPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}