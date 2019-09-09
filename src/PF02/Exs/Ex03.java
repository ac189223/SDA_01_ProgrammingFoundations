package PF02.Exs;

public class Ex03 {

    public Ex03() { }

    public int sum100() {
        int sum = 0;
        for (int i = 1; i < 101; i++)
            sum += i;
        return sum;
    }

    public boolean highest(double num1, double num2) { return (num1 > num2); }

    public String concat(String string, int times) { return string.repeat(Math.max(times, 1)); }

    public int stringLength(String string) { return string.length(); }

    public char string1(String string, int index) { return string.charAt(index % string.length()); }

    public String string2(String string, int index) { return string.substring(0, Math.min(index, string.length())); }

    public String string3(String string, int index) { return string.substring(Math.max(0, stringLength(string) - index)); }

    public int countA(String string) {
        int count = 0;
        for (int i = 0; i < stringLength(string); i++) {
            if (string.charAt(i) == 'A')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Ex03 exercise = new Ex03();
        System.out.println("Sum of numbers from 1 to 100 is: " + exercise.sum100());
        System.out.println("Is 34.3 higher than 23.32? " + exercise.highest(34.3, 23.32));
        System.out.println("Repeating four times \"kitty\" we can get " + exercise.concat("kitty", 4));
        System.out.println("Length of word \"entrepreneur\" is: " + exercise.stringLength("entrepreneur"));
        System.out.println("Character on place 3 in word \"bicycle\" is: " + exercise.string1("bicycle", 3));
        System.out.println("First two letters of \"computer\" are: " + exercise.string2("computer", 2));
        System.out.println("And the last 5 are:  " + exercise.string3("computer", 5));
        System.out.println("Letter 'A' appears " + exercise.countA("Annual") + " times in \"Annual\"");
    }
}
