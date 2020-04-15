package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class LambdaDemo2 {

    public static void main(String[] args) {

        NumericTest isEven = (n) -> (n%2)==0;
        System.out.println("9 is even: ");
        System.out.println(isEven.test(9));
        System.out.println("10 is even: ");
        System.out.println(isEven.test(10));

        NumericTest isNonNeg = (n) -> n>=0;
        System.out.println("-5 is not negative number: ");
        System.out.println(isNonNeg.test(-5));
        System.out.println("7 is not negative number: ");
        System.out.println(isNonNeg.test(7));

    }
}

interface NumericTest {
    boolean test (int n);
}
