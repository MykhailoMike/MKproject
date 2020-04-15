package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.byteBasedStream;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("output-File can not be opened");
            return;
        } catch (IOException e) {
            System.out.println("io-error:" + e);
        }

        try (DataInputStream din = new DataInputStream(new FileInputStream("Test.dat"))) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            System.out.println("Output: " + d + " " + i + " " + b);
        } catch (FileNotFoundException e) {
            System.out.println("input-File can not be opened");
            return;
        } catch (IOException e) {
            System.out.println("io-error:" + e);
        }
    }
}
