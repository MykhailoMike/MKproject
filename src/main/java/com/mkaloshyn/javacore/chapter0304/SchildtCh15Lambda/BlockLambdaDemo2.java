package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class BlockLambdaDemo2 {

    public static void main(String[] args) {

        StringFunc s = (str) -> {
            String res = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--) {
                res += str.charAt(i);
            }
            return res;
        };

        System.out.println("Lambda is reversed to: " + s.func("Lambda"));
        System.out.println("Function is reversed to: " + s.func("Function"));
    }
}

interface StringFunc {
    String func(String str);
}
