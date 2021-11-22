package LongestWord;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LongestWorld {

    public static String LongestWord(String sen) {
        // code goes here
        String result = "";
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher m = p.matcher(sen);
        while(m.find()){
            //m.find();
            if(result.length() < sen.substring(m.start(), m.end()).length())
                result = sen.substring(m.start(), m.end());
        }

        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String str = "a b c dee";
        System.out.print(LongestWord(str));
    }

}
