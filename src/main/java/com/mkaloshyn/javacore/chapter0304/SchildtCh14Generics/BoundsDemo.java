package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh14Generics;

public class BoundsDemo {

    public static void main(String[] args) {

        Integer[] inums = new Integer[]{1, 2, 3, 4, 7, 9, 5, 5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("average value: " + v);

    }
}

class Stats<T extends Number> {
    T[] nums;

    Stats(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }
}
