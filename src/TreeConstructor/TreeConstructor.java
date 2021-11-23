package TreeConstructor;


import java.util.*;
import java.io.*;

public class TreeConstructor {

    public static String TreeConstructor(String[] strArr) {
        // code goes here
        boolean condition = true;
/*        int index = -1;
        String key;
        while (condition && ++index < strArr.length) {
            key = strArr[index].substring(
                    strArr[index].indexOf(',') + 1
                    , strArr[index].length() - 1);
            System.out.println(key);
        }

        return "true";
    }

    public static int left(String[] strArr, String key) {
*/        int result = 0;
        int index = -1;
        int jndex = -1;
        int lefts = 0;
        int rigth = 0;
        int parents = 0;
        int apexes = -1;
        int element, elem = -1, pair;
        while (condition && ++jndex < strArr.length) {
            lefts = 0;
            rigth = 0;
            parents = 0;
            element = Integer.valueOf(strArr[jndex].substring(
                    strArr[jndex].indexOf(',') + 1
                    , strArr[jndex].length() - 1));
            index = -1;

            while (condition && ++index < strArr.length) {
                elem = Integer.valueOf(strArr[index].substring(
                        strArr[index].indexOf(',') + 1
                        , strArr[index].length() - 1));
                if (elem ==element) {
//                    parents++;
                    pair = Integer.valueOf(strArr[index].substring(
                            1, strArr[index].indexOf(',')));
                    if(pair < elem)
                        lefts++;
                    else
                        rigth++;
                } else {
                    pair = Integer.valueOf(strArr[index].substring(
                            1, strArr[index].indexOf(',')));
                    if(pair == element)
                        parents++;
                }
            }
//                        System.out.println("element="+element+": left="
//                        +lefts+", rigth="+rigth+", parents="+parents);

            if (parents == 0)
                if (apexes == element || apexes <0)
                    apexes = element;
                else
                    condition = false;
            if(/*apexes>2 || */lefts >1 || rigth >1)
                condition = false;
        }
//        System.out.println("Number of orphans= "+apexes);
    return condition ? "true" : "false";
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        String[] in = new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
//        String[] in = new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
//        in = new String[]{"(2,5)", "(2,6)"};
        //        System.out.print(TreeConstructor(s.nextLine()));
        System.out.print(TreeConstructor(new String[]{"(2,5)", "(2,6)"}));
        System.out.print(TreeConstructor(new String[]{"(5,6)", "(6,3)", "(2,3)", "(12,5)"}));
    }

}