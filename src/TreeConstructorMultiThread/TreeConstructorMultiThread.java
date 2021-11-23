package TreeConstructorMultiThread;

/*
Tree Constructor
Have the function TreeConstructor(strArr) take the array of strings stored in strArr, which will contain pairs of integers in the following format: (i1,i2), where i1 represents a child node in a tree and the second integer i2 signifies that it is the parent of i1. For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"], then this forms the following tree:



which you can see forms a proper binary tree. Your program should, in this case, return the string true because a valid binary tree can be formed. If a proper binary tree cannot be formed with the integer pairs, then return the string false. All of the integers within the tree will be unique, which means there can only be one node in the tree with the given integer value.
Examples
Input: new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}
Output: true
Input: new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"}
Output: false
*/

import java.util.Scanner;




        import java.util.*;
        import java.io.*;

public class TreeConstructorMultiThread {

        // code goes here
    static String[] strArr;
    static final Object symophor = new Object();
    static     int apexes = -1;
      static boolean condition = true;

      static   class CheckElement extends Thread {
            int element;
            int lefts = 0;
            int rigth = 0;
            int parents = 0;
            public CheckElement (int element){
                this.element = element;
            }

            public void run(){
//                System.out.println("Thread "+element+" started");
                int index = -1;
                int elem, pair;
                while (condition && ++index < strArr.length) {
                    elem = Integer.valueOf(strArr[index].substring(
                            strArr[index].indexOf(',') + 1
                            , strArr[index].length() - 1));
                    if (elem == element) {
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

                synchronized (symophor) {
                if (parents == 0)
                        if (apexes == element || apexes < 0)
                            apexes = element;
                        else
                            condition = false;
                        if (/*apexes>2 || */lefts > 1 || rigth > 1)
                            condition = false;
                    }
/*                System.out.println("element="+element+": left="
                        +lefts+", rigth="+rigth+", parents="+parents
                        +" ; apex = " + apexes+", condition= "+condition);
*/            }

            }


    public static String TreeConstructor(String[] strArrIn) {
        strArr = strArrIn;
        List<Integer> checked = new ArrayList<>();
        CheckElement[] checkElements = new CheckElement[strArr.length];
        int result = 0;
        int jndex = -1;
//        int apexes = -1;
        int element;

        while (condition && ++jndex < strArr.length) {
            element = Integer.valueOf(strArr[jndex].substring(
                    strArr[jndex].indexOf(',') + 1
                    , strArr[jndex].length() - 1));
            if(!checked.contains(element)) {
            checked.add(element);
            checkElements[jndex] = new CheckElement(element);
                checkElements[jndex].start();
            }
        }
//        jndex= -1;
        while ( condition && --jndex >=0 ) {
            if(checkElements[jndex] != null
                    && checkElements[jndex].isAlive())
                try {
                    checkElements[jndex].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }

//        System.out.println("Number of orphans= "+apexes);
        return condition ? "true" : "false";
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
//        System.out.print(TreeConstructor(new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
//        System.out.print(TreeConstructor(new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"}));
//        in = new String[]{"(2,5)", "(2,6)"};
        //        System.out.print(TreeConstructor(s.nextLine()));
//        System.out.print(TreeConstructor(new String[]{"(2,5)", "(2,6)"}));
//        System.out.print(TreeConstructor(new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"}));
//        System.out.print(TreeConstructor(new String[]{"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)"}));
        System.out.print(TreeConstructor(new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
    }

}