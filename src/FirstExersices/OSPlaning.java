package FirstExersices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> task = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(task::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true){
            Integer currentTask = task.peek();
            Integer currentThread = threads.peek();

            if (currentThread >= currentTask){
                task.pop();
                threads.pop();
            }else if (currentThread < currentTask){
                threads.pop();
            }
            if (currentTask == taskToKill){
                threads.push(currentThread);
                break;
            }
        }

        System.out.printf("Thread with value %d killed task %d\n",threads.peek(),task.peek());


        for (Integer thread : threads) {
            System.out.printf("%d ",thread);
        }

    }
}
