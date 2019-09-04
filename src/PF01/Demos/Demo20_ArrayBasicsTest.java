package PF01.Demos;

public class Demo20_ArrayBasicsTest {
    public static void main(String[ ] args) {
        int[] intArray1;
        intArray1 = new int[3];
        int[] intArray2 = new int[3];

//Storage
        intArray1[0] = 2;
        intArray1[1] = 4;
        intArray1[2] = 3;

//Go through the array
        for (int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }

        intArray2[2] = 82;
        intArray2[1] = intArray2[2] + 12;
        System.out.println(intArray2[2]);
        System.out.println(intArray2[1] / 2);
    }
}
