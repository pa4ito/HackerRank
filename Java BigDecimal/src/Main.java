/*
Java's BigDecimal class can handle arbitrary-precision signed decimal numbers. Let's test your knowledge of them!

Given an array, "s", of "n" real number strings, sort them in descending order — but wait, there's more! Each number must be printed in the exact same format as it was read from stdin, meaning that ".1" is printed as ".1", and "0.1" is printed as "0.1". If two numbers represent numerically equivalent values (e.g., ".1" "0.1"), then they must be listed in the same order as they were received as input).

Complete the code in the unlocked section of the editor below. You must rearrange array "s"'s elements according to the instructions above.

Input Format
------------
The first line consists of a single integer, "n", denoting the number of integer strings.
Each line "i" of the "n" subsequent lines contains a real number denoting the value of "sI".

Constraints
-----------
    -> 1 <= n <= 200
    -> Each "sI" has at most 300 digits.

Output Format
-------------
Locked stub code in the editor will print the contents of array "s" to stdout. You are only responsible for reordering the array's elements.

Sample Input
------------
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

Sample Output
-------------
90
56.6
50
02.34
0.12
.12
0
000.000
-100
*/

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                BigDecimal a = new BigDecimal(s1);
                BigDecimal b = new BigDecimal(s2);
                return b.compareTo(a); // descending order
            }
        };

        Arrays.sort(s, 0, n, customComparator);
        //

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}