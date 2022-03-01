package Java_Mentor.block_6_Generics;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_6_2_15 {
public static void main(String[] args) throws IOException {//FileNotFoundException {
    Reader reader = new FileReader("/Users/paulmezoni/Desktop/test");  // (Свой путь файла ставь)
    try {
        System.out.println(getSalesMap(reader));
    } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
    }
}
//        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
//        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));
//        getSalesMap(buffReader);
//    }

public static Map<String, Long> getSalesMap(Reader reader) throws ArrayIndexOutOfBoundsException {
    //Твой код здесь
    HashMap<String, Long> hashMap = new HashMap<>();
    String strings;
    Long longs = null;
    try (Scanner scanner = new Scanner(reader)) {
        while (scanner.hasNext()) {
            strings = scanner.next();
            if (scanner.hasNext()) {
                longs = scanner.nextLong();
            }
            hashMap.merge(strings, longs, (old, n) -> old + n);
        }
    }
    return hashMap;
}
}


//        Map<String, Long> map = new HashMap<>();
//        try (Scanner scanner = new Scanner(System.in)) {
//            for (int i = 0; scanner.hasNext(); i++) {
//                if (scanner.hasNextInt() && (i % 2 != 0)) {
//                    map.merge(scanner.nextLine());
//                } else {
//                    scanner.next();
//                }
//            }
//            map.forEach(s -> System.out.print(s + " "));
//        }
//    }

//        String line;
//        while ((line = String.valueOf(reader.read())) != null) {
//            String name = line.trim().split(" ")[0];
//            Integer salary = Integer.parseInt(line.trim().split(" ")[1]);
//            map.put(name, Long.valueOf(salary));
//        }
//        return map;
//        String line;
//        while ((line = String.valueOf(reader.ready())) != null) {
//            assert false;
//            String name = line.trim().split(" ")[0];
//            Long salary = Long.parseLong(line.trim().split(" ")[1]);
//            if (map.containsKey(name)) {
//                map.merge(name, map.get(name) + salary);
//            } else {
//                map.put(name, salary);
//            }
//        }
//        return map;
//    }
//}

//
//    BufferedReader br = new BufferedReader(reader);
//    String thisLine = null;
//    HashMap<String, Long> map = new HashMap<>();
//        try
//
//    {
//        thisLine = br.readLine();
//    } catch(
//    IOException e)
//
//    {
//        e.printStackTrace();
//    }
//        assert thisLine !=null;
//    String[] part = thisLine.split("(?<=\\D)(?=\\d)");
////        part = thisLine.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])");
//        for(
//    int j = 0;
//    j<part.length;j =j +2)
//
//    {
//        int a = Integer.parseInt(part[j + 1]);
//        map.put(part[j], (long) a);
//    }
//        return map;
//}
//}


