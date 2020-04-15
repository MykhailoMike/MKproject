package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

public class WriteDemo {
    public static void main(String[] args) {
        int b;
        b = 'щ';
        System.out.write(b); //несмотря на то, что параметр обїявлен как int, записываются лишь 8 младших битов
        System.out.write('\n');
        System.out.print("Текст");
    }
}
