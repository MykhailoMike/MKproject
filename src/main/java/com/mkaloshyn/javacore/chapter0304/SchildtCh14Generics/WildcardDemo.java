package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh14Generics;

public class WildcardDemo {

    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Statss<Integer> iob = new Statss<Integer>(inums);
        double v = iob.average();
        System.out.println("Average of iob: " + v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Statss<Double> dob = new Statss<Double>(dnums);
        double w = dob.average();
        System.out.println("Average of dob: " + w);

        Float[] fnums = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        Statss<Float> fob = new Statss<Float>(fnums);
        double f = fob.average();
        System.out.println("Average of fob: " + f);

        System.out.print("Average of iob and dob are ");
        if (iob.sameAvg(dob)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        System.out.print("Average of iob and fob are ");
        if (iob.sameAvg(fob)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}

class Statss<T extends Number> {
    T[] nums;

    Statss(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Statss<?> obj) {
        return average() == obj.average();
    }

}
