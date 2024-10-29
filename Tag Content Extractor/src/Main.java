/*
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        List<String> inputStr = new ArrayList<>();
        List<String> listToPrint = new ArrayList<>();
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            inputStr.add(sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            str = inputStr.get(i);
            if (str == null || str.isEmpty() || str.charAt(0) != '<')
                System.out.println("None");
            else {
                Stack<String> stack = new Stack<>();

                while (str != null && !str.isEmpty()) {
                    String tag = getTag(str);
                    if (tag == null || tag.isEmpty()) {
                        System.out.println("None");
                        break;
                    }
                    if (str.length() > tag.length() + 2)
                        str = str.substring(tag.length() + 2);
                    else
                        str = null;

                    if (tag.charAt(0) == '/') {
                        // Closing tag
                        if (tag.replace("/", "").equals(stack.peek())) {
                            if (str == null) {
                                stack.pop();
                                break;
                            }
                            else {
                                str = str.substring(tag.length() + 2);
                                if (str.indexOf("<") < 1)
                                    if (str.indexOf(">") < 1) {
                                        System.out.println(str);
                                        stack.pop();
                                        str = null;
                                    } else {
                                        System.out.println("None");
                                        break;
                                    }
                                else {
                                    if (str.charAt(0) != '<') {
                                        System.out.println("None");
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("None");
                            break;
                        }
                    } else {
                        if (str == null)
                            break;
                        else {
                            if (str.charAt(0) == '<') {
                                // Opening tag
                                tag = getTag(str);
                                if (tag == null || tag.isEmpty()) {
                                    System.out.println("None");
                                    break;
                                }
                                stack.push(tag);
                                str = str.substring(tag.length() + 2);
                            } else {
                                // Text to print
                                int closingTagPos = 0;
                                if ((closingTagPos = str.indexOf("</")) > 0) {
                                    System.out.println(str.substring(0, closingTagPos));
                                    //listToPrint.add(str);
                                    str = str.substring(closingTagPos);

                                }
                            }
                        }
                    }
                }
            }
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
}