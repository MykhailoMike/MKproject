package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String str = "Эти данные должны быть введены в массив";
        byte[] b = str.getBytes();

        try {
            f.write(b);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while writing into buffer");
            return;
        }

        System.out.println("Буффер в виде символьной строки: ");
        System.out.println(f.toString());

        System.out.println("В массив: ");
        byte[] c = f.toByteArray();
        for (byte element : c) {
            System.out.print((char) element);
        }

        System.out.println("\nВ поток вывода типа OutputStream");
        try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("IO Error : " + e);
            return;
        }

        System.out.println("Установка в исходное состояние");
        f.reset();
        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());

    }
}
