package Lesson7;

import java.util.Random;

public class LocalClassTest {
    public static void main(String args[]) {
        IntSequence seq = randomints(3,5);
        System.out.println(seq.next());
        System.out.println(seq.next());
        System.out.println(seq.next());
    }
    private static Random generator = new Random();

    public static IntSequence randomints(int low, int high) {
        class RandomSequence implements IntSequence {
            @Override
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }
        }
        return new RandomSequence();
    }

}
