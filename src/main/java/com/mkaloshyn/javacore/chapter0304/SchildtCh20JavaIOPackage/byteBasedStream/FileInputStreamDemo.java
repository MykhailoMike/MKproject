package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;
//мій file
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        try (FileInputStream f = new FileInputStream("src/main/java/com/mkaloshyn/javacore/chapter0304/SchildtCh20JavaIOPackage/FileInputStreamDemo.java")) {
            System.out.println("The toatl number of available bytes: " + (size = f.available()));
            int n = size / 40;
            System.out.println("First " + n + " bytes, read from file in order using read() method");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }

            System.out.println("\nStill available: " + f.available());

            System.out.println("Reading of the next n bytes using read(b[]) method");
            byte[] b = new byte[n];
            if (f.read(b) != n) {
                System.err.println("It is impossible to read " + n + " bytes.");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("Still available: " + (size = f.available()));
            System.out.println("Skip the half of bytes left using method skip()");
            f.skip(size / 2);
            System.out.println("Still available: " + f.available());
            System.out.println("Reading " + n / 2 + " bytes, located in the end of array");
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("It is imposssible to read " + n / 2 + " bytes");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("Still available: " + f.available());
        } catch (IOException e) {
            System.out.println("Error of Input-Output: " + e);
        }
    }
}
