package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.*;

public class CharArrayWriteDemo {
    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String str = "Эти данные должны быть введены в массив";
        char[] b = new char[str.length()];
        str.getChars(0, str.length(), b,0);

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
        char[] c = f.toCharArray();
        for (char element : c) {
            System.out.print((char) element);
        }

        System.out.println("\nВ поток вывода типа FileWriter");
        try (FileWriter f2 = new FileWriter("test2.txt")) {
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
