package FirstExersices;

import java.util.*;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(daffodils::add);

        int bouquets = 0;

//        Map<Integer, Integer> storedMap = new LinkedHashMap<>();

        List<Integer> sorted = new ArrayList<>();

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            Integer tulip = tulips.peek();
            Integer daffodil = daffodils.peek();

            int sum = tulip + daffodil;
            if (sum == 15) {
                bouquets++;
                tulips.pop();
                daffodils.pop();
                if (bouquets ==5){
                    break;
                }
            }

            while (sum > 15) {
                tulip -= 2;
                tulips.pop();
                tulips.push(tulip);
                sum = tulip + daffodil;
            }

            if (sum < 15) {
                sorted.add(sum);
//                storedMap.put(tulip, daffodil);
                tulips.pop();
                daffodils.pop();
            }

        }
        int totalFlowers = 0;
        for (Integer integer : sorted) {
            totalFlowers +=integer;
        }
        int bonusBouquet = totalFlowers/15;
        System.out.println();

        int result = bouquets + bonusBouquet;
        if (result < 5){
            System.out.printf("You failed... You need more %d bouquets.", Math.abs(result - 5));
        }else {
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        }
    }
}
