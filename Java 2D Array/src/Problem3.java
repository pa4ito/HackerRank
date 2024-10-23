/*
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

You are given "n" lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in "y-th" position of "x-th" line.

Take your input from System.in.

Input Format
------------
The first line has an integer "n". In each of the next "n" lines there will be an integer "d" denoting number of integers on that line and then there will be "d" space-separated integers. In the next line there will be an integer "q" denoting number of queries. Each query will consist of two integers "x" and "y".

Constraints
-----------
-> 1 <= n <= 20000
-> 0 <= d <= 50000
-> 1 <= q <= 1000
-> 1 <= x <= n

Each number will fit in signed integer.
Total number of integers in "n" lines will not cross 10^5.

Output Format
-------------
In each line, output the number located in "y-th" position of "x-th" line. If there is no such position, just print "ERROR!"

Sample Input
------------
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output
-------------
74
52
37
ERROR!
ERROR!

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> internalList;
        List<String> listq = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String s = bufferedReader.readLine();
                String[] sArr = s.split(" ");
                internalList  = new ArrayList<>();
                if (Integer.parseInt(sArr[0]) > 0) {
                    for (int j = 1; j < sArr.length; j++)
                        internalList.add(Integer.parseInt(sArr[j]));
                }
                list.add(internalList);
            }

            int q = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < q; i++) {
                listq.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : listq) {
            String[] sArr = s.split(" ");
            int x = Integer.parseInt(sArr[0]);
            int y = Integer.parseInt(sArr[1]);

            if (x > list.size())
                System.out.println("ERROR!");
            else {
                internalList = list.get(x - 1);
                if (y > internalList.size())
                    System.out.println("ERROR!");
                else
                    System.out.println(internalList.get(y - 1));
            }
        }
    }

}
