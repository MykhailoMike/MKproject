package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class LambdaAsArgumentsDemo {

    public static void main(String[] args) {

        String strIn = "Lambdas make Java more efficient";
        String strOut;

        System.out.println("This is initial string: " + strIn);

        strOut = stringOp((s) -> s.toUpperCase(), strIn);
        System.out.println("This is the string in upper case: " + strOut);

        strOut = stringOp((s) -> {
            String sOut = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    sOut += s.charAt(i);
                }
            }
            return sOut;
        }, strIn);
        System.out.println("This string without spaces: " + strOut);

        StringFuncArg reverse = (str) -> {
            String res = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                res += str.charAt(i);
            }
            return res;
        };
        strOut = stringOp(reverse, strIn);
        System.out.println("Reversed string: " + strOut);


    }

    static String stringOp(StringFuncArg sf, String str) {
        return sf.func(str);
    }
}

interface StringFuncArg {
    String func(String str);
}