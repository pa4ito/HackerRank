import java.util.*;

/*
We define the following terms:
    - Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
        A < B < ... < Y < Z < a < b < ... < y < z
    For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

    - A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string, "s", and an integer, "k", complete the function so that it finds the lexicographically smallest and largest substrings of length "k".

Function Description
--------------------
Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:
    - string s: a string
    - int k: the length of the substrings to find

Returns
-------
    string: the string ' + "\n" + ' where and are the two substrings

Input Format
------------
The first line contains a string denoting "s".
The second line contains an integer denoting "k".

Constraints
-----------
    1 <= "s" <= 1000
    "s" consists of English alphabetic letters only (i.e., [a-zA-Z]).

Sample Input 0
--------------
welcometojava
3

Sample Output 0
---------------
ava
wel

Explanation 0
-------------
String "s" = "welcometojava" has the following lexicographically-ordered substrings of length "k" = 3:

["ava", "com", "elc", "eto", "jav", "lco", "met", "oja", "ome", "toj", "wel"]


We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).

The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
*/
public class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

//        if (s.length() <= k) {
//            smallest = largest = s;
//        } else {
//            List<String> listSubArrays = new ArrayList<>();
//            int j = s.length() - k;
//            for (int i = 0; i <= j; i++) {
//                listSubArrays.add(s.substring(i,k++));
//            }
//            String[] arr = listSubArrays.toArray(new String[listSubArrays.size()]);
//            Arrays.sort(arr, (a,b) -> a.compareTo(b));
//            smallest = arr[0];
//            largest = arr[arr.length - 1];
//        }

        if (s.length() <= k) {
            smallest = largest = s;
        } else {
            int j = s.length() - k + 1;
            String[] arr = new String[j];
            for (int i = 0; i < j; i++) {
               arr[i] = s.substring(i,k++);
               if(i == 0) {
                   smallest = largest = arr[0];
               }
                if (smallest.compareTo(arr[i]) >= 0)
                    smallest = arr[i];
                if(largest.compareTo(arr[i]) < 0)
                    largest = arr[i];

            }
        }

        return smallest + "\n" + largest;
    }
}
