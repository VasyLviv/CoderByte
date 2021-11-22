package BracketCombination;

import java.util.*;
        import java.io.*;

public class BracketCombination {

    static int count = 0;

    // Function that print all combinations of
    // balanced parentheses
    // open store the count of opening parenthesis
    // close store the count of closing parenthesis
// Thanx to Pramod Kumar

    static void _printParenthesis(/*char str[],*/ int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
/*            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
*/            count++;
            return;
        }
        else
        {
            if(open > close) {
//                str[pos] = '}';
                _printParenthesis(/*str, */pos+1, n, open, close+1);
            }
            if(open < n) {
//                str[pos] = '{';
                _printParenthesis(/*str, */pos+1, n, open+1, close);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(/*char str[],*/ int n)
    {
        if(n > 0)
            _printParenthesis(/*str, */0, n, 0, 0);
        return;
    }

    // driver program


    public static int BracketCombinations(int num) {

//        int n = num;
//        char[] str = new char[2 * num];
        printParenthesis(/*str, */num);
//        System.out.println("Combinations = "+count);
        return count;
    }


    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketCombinations(8));
    }

}
