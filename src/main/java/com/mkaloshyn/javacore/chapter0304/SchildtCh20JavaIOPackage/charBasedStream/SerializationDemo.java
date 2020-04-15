package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh20JavaIOPackage.charBasedStream;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOstrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MyClass obj1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("Object1: " + obj1);
            objOstrm.writeObject(obj1);
        } catch (IOException e) {
            System.out.println("Error while serializing");
        }

        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
            MyClass obj2 = (MyClass) objIStrm.readObject();
            System.out.println("Object2: " + obj2);
        } catch (Exception e) {
            System.out.println("Error while deserializing");
        }
    }
}

class MyClass implements Serializable {
    transient String s;
    transient int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public String toString() {
        return "s = " + s + "; i = " + i + "; d = " + d;
    }
}

