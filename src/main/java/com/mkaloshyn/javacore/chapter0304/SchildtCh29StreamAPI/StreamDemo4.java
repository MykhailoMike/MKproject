package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh29StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamDemo4 {
    public static void main(String[] args) {
        List<Double> dList = new ArrayList<>();
        dList.add(1.1);
        dList.add(3.12);
        dList.add(4.45);
        dList.add(8.710);
        dList.add(9.05);

        IntStream intStream = dList.stream()
                .mapToInt((a) -> (int) Math.ceil(a));

        intStream.forEach((a)-> System.out.print(a + " "));
    }
}
