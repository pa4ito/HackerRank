import java.util.Collections;
import java.util.Scanner;

/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string "A", print Yes if it is a palindrome, print No otherwise.

Constraints
-----------
 - "A" will consist at most 50 lower case english letters.

Sample Input
------------
madam

Sample Output
-------------
Yes
*/
public class Problem4 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        String isPalindrome = "Yes";
        int j = A.length();
        for (int i = 0; i < A.length() / 2 ; i++) {
            String sLeft = A.substring(i, i+1);
            String sRight = A.substring(j - 1, j);
            if (!sLeft.equals(sRight)){
                isPalindrome = "No";
                break;
            }
            j--;
        }
        System.out.println(isPalindrome);
    }
}
