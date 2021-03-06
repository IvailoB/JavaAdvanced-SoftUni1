package StacksAndQueuesExe;

import java.lang.reflect.Array;
import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int toPush = input[0];
        int toPop = input[1];
        int searchElement = input[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < toPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < toPop; i++) {
            stack.pop();
        }
        if (stack.contains(searchElement)){
            System.out.println("true");
        }else if (stack.isEmpty()){
            System.out.println("0");
        }else {
            System.out.println(Collections.min(stack));
        }
    }
}
