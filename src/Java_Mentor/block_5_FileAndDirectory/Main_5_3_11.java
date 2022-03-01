package Java_Mentor.block_5_FileAndDirectory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

//5.3.11
public class Main_5_3_11 {
public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    //Твой код здесь
    return new String(inputStream.readAllBytes(), charset);
}

public static void main(String[] args) throws IOException {
    //5.3.11
    byte[] bb = new byte[]{48, 49, 50, 51}; //0, 1, 2, 3
    ByteArrayInputStream bis = new ByteArrayInputStream(bb);
    System.out.println(readAsString(bis, StandardCharsets.US_ASCII));
}
}
