package PF01.ArraySorting;

import java.util.Random;

public class Dina_arraySorter {
        public static void main(String[] args) {
            // TODO Auto-generated method stub

            Random generator = new Random ();
            int[] List = new int[10];
            int swap ;

            //fill up Array
            for (int i = 0 ; i < 10 ; i++) {
                List[i]= generator.nextInt(1000)  ;
                System.out.print(List[i] + " ");
            }
            System.out.println();

            //Compare each number with remaining  numbers
            int pointer = 0 ;
            while(pointer < 9) {
                for (pointer = 0 ; pointer < 9 ; pointer ++) {
                    if ((List[pointer]) > (List[(pointer+1)])) {
                        swap = List[pointer];
                        List[pointer] = List[pointer + 1];
                        List[pointer + 1] = swap;
                        for (int i = 0 ; i < 10 ; i++) {
                            System.out.print(List[i] + " ");
                        }
                        System.out.println();
                        break;
                    }
                }
            }
        }
}