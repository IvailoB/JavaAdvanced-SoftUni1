package StacksAndQueuesExe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean flag = true;

        for (int i = 0; i < brackets.length(); i++) {
            char openBracket = brackets.charAt(i);
            if (openBracket == '(' || openBracket == '{' || openBracket == '[') {
                stack.push(openBracket);
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                char closeBracket = stack.pop();
                if (openBracket == ')' && closeBracket != '(') {
                    flag = false;
                    break;
                } else if (openBracket == ']' && closeBracket != '[') {
                    flag = false;
                    break;
                } else if (openBracket == '}' && closeBracket != '{') {
                    flag = false;
                    break;
                }

            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
