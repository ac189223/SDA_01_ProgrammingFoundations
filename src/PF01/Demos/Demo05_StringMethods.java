package PF01.Demos;

public class Demo05_StringMethods {
    public static void main (String [] args){
        int length;
        String sign;
        String personOne = "Anna Nilsson";
        String personTwo = "Hans Andersson";

        personOne = personOne.toUpperCase();        //ANNA NILSSON
        personTwo = personTwo.toLowerCase();        //hans andersson

        System.out.println(personOne);
        System.out.println(personTwo);

        length = personOne.length();                //12
        sign = personTwo.substring(1,2);            //a

        personOne = personOne.replace('N','X');     //AXXA XILSSOX
        personTwo = personTwo.substring(0,4);                       //hans

        System.out.println(personOne);
        System.out.println(personTwo);
        System.out.println(length);
        System.out.println(sign);
    }
}
