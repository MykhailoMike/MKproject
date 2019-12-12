package main.java.com.mkaloshyn.javacore.chapter02.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 4, 5, 7, 11};
        System.out.println("Input: " + Arrays.toString(arr));

        MyCollection myCollection = new MyCollection(arr);

        myCollection.addElement(8);
        System.out.println(myCollection);
    }
}
