package BracketMatcher;

import java.util.*;
        import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketMatcher {

    public static String BracketMatcher(String str) {
        // code goes here
        Pattern p = Pattern.compile("\\(");
        Matcher m = p.matcher(str);
        int counter=0;
        while (m.find())
            counter++;
        p = Pattern.compile("\\)");
        m = p.matcher(str);
        while (m.find())
            counter--;


        return counter == 0 ? "1" : "0";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketMatcher("((coder)(byte))"));
//        System.out.print(BracketMatcher(s.nextLine()));
    }

}