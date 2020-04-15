package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class LambdaDemo3 {

    public static void main(String[] args) {

        NumericTest2 nt2 = (n, d) -> (n%d)==0;

        System.out.println(nt2.test(40, 8));
        System.out.println(nt2.test(13,5));
        System.out.println(nt2.test(49,7));
    }
}

interface NumericTest2 {
    boolean test (int n, int d);
}
