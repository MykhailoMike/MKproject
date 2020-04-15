package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class GenericFunctionalInterfaceDemo {

    public static void main(String[] args) {

        SomeFunc<String> reverse = (str) -> {
            String res = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                res += str.charAt(i);
            }
            return res;
        };

        System.out.println("Lambda is reversed to: " + reverse.func("Lambda"));
        System.out.println("Function is reversed to: " + reverse.func("Function"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("3 factorial is " + factorial.func(3));
        System.out.println("5 factorial is " + factorial.func(5));
    }
}

interface SomeFunc<T> {
    T func(T t);
}
