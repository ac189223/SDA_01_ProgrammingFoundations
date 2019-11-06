package Random.Concurrency_Johan.Ch01_Ch02;

/**
 * http://sde.cs.lth.se/education/phd-courses/advanced-concurrent-programming-in-java/
 */
public class UnsafeSequence {
    private int value;

    public int getNext() {
        return value++;
    }
}
