package java_lang;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by naco_siren on 8/21/17.
 */
public class stream {

    public static void main(String[] args) {
        String input = "ABCxyz123$%!";
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(stream);

//        String s1 = scanner.next();
//        String s2 = scanner.next();
//        String s3 = scanner.next();

        char b1 = (char) scanner.nextByte();
        Byte b2 = scanner.nextByte();
        Byte b3 = scanner.nextByte();

        return;
    }
}
