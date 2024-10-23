/*
Two strings, "a" and "b", are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description
--------------------
Complete the isAnagram function in the editor.

isAnagram has the following parameters:
    - string a: the first string
    - string b: the second string

Returns
-------
    boolean: If "a" and "b" are case-insensitive anagrams, return true. Otherwise, return false.

Input Format
------------
The first line contains a string "a".
The second line contains a string "b".

Constraints
-----------
    - 1 <= length(a), length(b) <= 50
    - Strings "a" and "b" consist of English alphabetic characters.
    - The comparison should NOT be case sensitive.

Sample Input 0
--------------
anagram
margana

Sample Output 0
---------------
Anagrams
*/

import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {
    static boolean isAnagram(String a, String b) {
        // Complete the function
//        char[] chArr1 = a.toLowerCase().toCharArray();
//        char[] chArr2 = b.toLowerCase().toCharArray();
//        Arrays.sort(chArr1);
//        Arrays.sort(chArr2);
//
//        for (int i = 0; i < chArr1.length; i++) {
//            if(chArr1[i] != chArr2[i])
//                return false;
//        }

        if(a.length() != b.length())
            return false;

        char[] chArr1 = a.toLowerCase().toCharArray();
        char[] chArr2 = b.toLowerCase().toCharArray();


        for (int i = 0; i < chArr1.length; i++) {
           int count = 1;
            for (int j = 0; j < chArr1.length; j++) {
                if ( i != j)
                    if (chArr1[j] == chArr1[i])
                        count++;
            }

            int count2 = 0;
            for (int j = 0; j < chArr2.length; j++) {
                if (chArr2[j] == chArr1[i])
                    count2++;
            }
            if(count != count2)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
