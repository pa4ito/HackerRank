/*
Tag Content Extractor

In a tag based language, like XML or HTML, contents are enclosed by a start tag and an end tag. For example:
    <tag>contents</tag>

In this problem, you will be given a text in a tag based language. Your task is to parse this text and retrieve
the contents which are enclosed by well organized tag sequences. Well organized tags maintain the following constraints:

The name of the start and end tag must be same. The following HTML code is not valid:

<h1>Hello World</h2>
Tag can be nested, but there will be no content in between the nested tags. The following code is not valid:

<h1><a>contents</a>invalid</h1>
Tags can consist of any printable characters.

Input Format

The first line of input contains a single integer N, representing the number of lines. The next N lines
contains a line of text.

Constraints

1<=N<=100
Each line contains at most 104 printable characters. The total number of characters in all test cases will not exceed 106.

Output Format

For each line, print the valid content enclosed by proper tags. If there is multiple valid content in a test case,
print out each of the valid content on separate lines. If no valid content is found in a test case, print "None" without quotes.

Sample Input
------------
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Sample Output
-------------
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush




10
<h1>some</h1>
<h1>had<h1>public</h1></h1>
<h1>had<h1>public</h1515></h1>
<h1><h1></h1></h1>
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>
<>hello</>
<>hello</><h>dim</h>
<>hello</><h>dim</h>>>>>

*/


import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            Stack<String> stack = new Stack<>();
            String tag = null;
            StringBuffer sb = new StringBuffer();
            boolean isPrintedSomething = false;
            String str = in.nextLine();

            while (str != null && !str.isEmpty()) {
                if (str.charAt(0) == '<') {
                    tag = getTag(str);

                    if (tag == null) {
                        sb.setLength(0);
                        stack.clear();
                        str = str.substring(1);
                        if (str.length() > 1)
                            str = removeCharsNotLT(str);
                        else
                            break;
                    } else {
                        if (tag.charAt(0) != '/') {
                            // Starting tag
                            if (str.length() == tag.length() + 2) {
                                break;
                            }
                            sb.setLength(0);
                            stack.clear();
                            stack.push(tag);
                            str = str.substring(tag.length() + 2);
                        } else {
                            // Ending tag
                            if (stack.isEmpty()) {
                                str = removeCharsNotLT(str);
                            } else {
                                if (tag.replace("/", "").equals(stack.peek())) {
                                    stack.pop();
                                    if (sb.length() > 0) {
                                        System.out.println(sb.toString());
                                        sb.setLength(0);
                                        isPrintedSomething = true;
                                    }
                                } else {
                                    stack.clear();
                                }
                            }

                            if (str.length() > tag.length() + 2) {
                                str = str.substring(tag.length() + 2);
                            } else {
                                str = null;
                                if (!stack.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    if (!stack.isEmpty()) {
                        sb.setLength(0);
                        for (int j = 0; j < str.length(); j++) {
                            if (str.charAt(j) != '<')
                                sb.append(str.charAt(j));
                            else
                                break;
                        }
                        str = str.substring(sb.toString().length());
                    }
                    if (str.isEmpty())
                        break;
                    else
                        str = removeCharsNotLT(str);
                }
            }

            if (!isPrintedSomething)
                System.out.println("None");

            testCases--;
        }
    }

    private static String getTag(String inputStr) {
        String result = null;
        if (inputStr.charAt(0) == '<') {
            int posL = inputStr.indexOf(">");
            if (posL > 1) {
                result = inputStr.substring(1, posL);
            }
        }
        return result;
    }

    private static String removeCharsNotLT(String str) {
        while (str.charAt(0) != '<') {
            str = str.substring(1);
            if (str.isEmpty())
                break;
        }
        return str;
    }
}

/*
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while(testCases>0 && in.hasNextLine()){
        String line = in.nextLine();
        String[] lines = line.split("\n");
        for (String string : lines) {
            String regex = "<(.+)>([^<>]+)</\\1>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                String match = matcher.group(2);
                System.out.println(match);
            }

            matcher.reset();

            if (matcher.find() == false) {
                System.out.println("None");
            }
        }
        testCases--;
    }
    in.close();
 */