package Java_Mentor.block_5_FileAndDirectory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SumStream {
public static void main(String[] args) throws IOException {

    //5.3.11
    byte[] bb = new byte[] {48, 49, 50, 51}; //0, 1, 2, 3
    ByteArrayInputStream bis = new ByteArrayInputStream(bb);
    System.out.println(readAsString(bis, StandardCharsets.US_ASCII));

    //5.3.10
//        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
//        writer.write("?");
//        writer.close();

    byte[] arr = {1, 2, 4, 10};
//        System.out.println(sumOfStream(new ByteArrayInputStream(arr)));

//        InputStream stream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
//        OutputStream outputStream = new ByteArrayOutputStream();
//        print(stream, outputStream);

    InputStream stream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
    OutputStream outputStream = new ByteArrayOutputStream();
//        print(stream, outputStream);

    //5.3.9
//        String s = "Ы";
//        byte[] b = s.getBytes();
//        for (byte value : b) {
//            System.out.print(((int) value ^ -1 << 8) + " ");
//        }

}

// 5.2.7
public static int sumOfStream(InputStream inputStream) throws IOException {
    //твой код здесь
    int i;
    int result = 0;
    while ((i = inputStream.read()) != -1) {
        result += (byte) i;
    }
    return result;
}

// 5.2.8
public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
    //твой код здесь
    int i;
    while ((i = inputStream.read()) != -1) {
        if ((i % 2) == 0) {
            outputStream.write(i);
        }
    }
    outputStream.flush();
}

//5.3.11
public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    //Твой код здесь
    try(ByteArrayOutputStream result = new ByteArrayOutputStream()) {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(charset);
    }
}
}

