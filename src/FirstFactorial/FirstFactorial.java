//Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it. For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24. For the test cases, the range will be between 1 and 18 and the input will always be an integer.


package FirstFactorial;

import java.util.*;
        import java.io.*;

public class FirstFactorial {

    public static int FirstFactorial(int num) {
        // code goes here
        if (num <=2)
            return num;
        return  num*FirstFactorial(num-1);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(FirstFactorial(9));
    }

}
