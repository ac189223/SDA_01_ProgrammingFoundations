package PF02.Recurrence;

public class sumRecurrentMethod {
    private static sumRecurrentMethod srm = new sumRecurrentMethod();

    private int sum(int i) {
        if (i > 0)
            return (sum(i - 1) + i);
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(srm.sum(100));
    }
}
