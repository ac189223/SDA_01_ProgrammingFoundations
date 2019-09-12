package PF02.Recurrence;

public class ConcatStrings {
    private static ConcatStrings cs = new ConcatStrings();

    private String concat(String string, int times) {
        if (times > 0)
            return concat(string, times - 1) + string;
        else
            return "";
    }

    public static void main(String[] args) {
        System.out.println(cs.concat("string", 5));
    }
}
