package ArraysIntersection;

import java.util.*;
        import java.io.*;
        import java.util.regex.*;

public class ArrayIntersection {

    public static String FindIntersection(String[] strArr) {
        // code goes here
        // code goes here
        String result = "";
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m1 = p.matcher(strArr[1]);
        String tempStr;
        while (m1.find()) {
            tempStr = strArr[1].substring(m1.start(), m1.end());
            if (strArr[0].contains(tempStr))
                result+=tempStr+',';
        }
        if (result.length()>0)
            return result.substring(0,result.length()-1);

        return "false";
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        String[] s = new String[] {"1, 2, 3, 4, 5", "6, 7, 8, 9, 10"};
        System.out.print(FindIntersection(s));
    }

}
