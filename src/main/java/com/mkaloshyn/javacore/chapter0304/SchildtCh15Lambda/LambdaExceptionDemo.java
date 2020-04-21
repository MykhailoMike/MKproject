package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh15Lambda;

public class LambdaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException {

        double[] values = {1.0, 2.0, 4.0, 3.3};
        DoubleArrayNumericFunc average = (n) -> {
            double sum = 0;

            if (n.length == 0) {
                throw new EmptyArrayException();
            }

            for (double v : n) {
                sum += v;
            }

            return sum / n.length;
        };

        System.out.println("Average is: " + average.func(values));
        System.out.println("Average on empty array is: " + average.func(new double[]{}));

    }
}

interface DoubleArrayNumericFunc {
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Array is empty");
    }
}

