package MinWindowSubstring;
import java.beans.PropertyEditorSupport;
import java.util.*;
import java.io.*;

/*
Min Window Substring
Have the function MinWindowSubstring(strArr) take the array of strings stored in strArr,
which will contain only two strings, the first parameter being the string N
and the second parameter being a string K of some characters,
and your goal is to determine the smallest substring of N
that contains all the characters in K.
For example: if strArr is ["aaabaaddae", "aed"] then
the smallest substring of N that contains the characters a, e, and d is "dae"
located at the end of the string. So for this example your program should return
the string dae.

Another example: if strArr is ["aabdccdbcacd", "aad"] then the smallest substring
of N that contains all of the characters in K is "aabd" which is located
at the beginning of the string. Both parameters will be strings ranging
in length from 1 to 50 characters and all of K's characters will exist somewhere
in the string N. Both strings will only contains lowercase alphabetic characters.
Examples
Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
Output: aksfaje
Input: new String[] {"aaffhkksemckelloe", "fhea"}
Output: affhkkse
 */
public class MinWindowSubstring {

    public String variation (String str, int position){
        String result="";
        return  result;
    }

    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        boolean found = false;
        StringBuilder pattern = new StringBuilder();
        String income = strArr[0];
//        char temp;
        StringBuilder result = new StringBuilder(strArr[0]);
        StringBuilder temp = new StringBuilder();
        int counter, index;

        for (int i= 0;  i<strArr[0].length(); i++) {
            if (found) break;
            counter=0;
            pattern.delete(0,pattern.length());
            pattern.append(strArr[1]);
            temp.delete(0,temp.length());
            for (int j = i; j < strArr[0].length()&& pattern.length()>0; j++) {
                index = pattern.indexOf(strArr[0].charAt(j)+"");
                if (index>=0) {
                    pattern.deleteCharAt(index);
                    counter++;
                }
                if (counter>0 )
                    temp.append(strArr[0].charAt(j));
                }
//            System.out.print("temp="+temp.toString());
            if (temp.length()<result.length()
                    && //temp.length()>=strArr[1].length())
                    pattern.length()==0)
                result.replace(0,result.length(), temp.toString());
            if (temp.length()==strArr[1].length())
                found = true;
//            System.out.println(", result="+result);
        }

        return  result.toString();
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String[] str = new String[] {"aaabaaddae", "aed"};
//        String[] str = new String[] {"ahffaksfajeeubsne", "jefaa"};
//        System.out.print(MinWindowSubstring(s.nextLine()));
        System.out.print(MinWindowSubstring(str));

    }

}
