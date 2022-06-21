package FirstExersices;

import java.util.*;
import java.util.stream.Collectors;

public class PastyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(ingredients::push);
        Map<String, Integer> integerMap = new LinkedHashMap<>();

        integerMap.put("Biscuit", 0);
        integerMap.put("Cake", 0);
        integerMap.put("Pie", 0);
        integerMap.put("Pastry", 0);
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            Integer liquid = liquids.peek();
            Integer ingredient = ingredients.peek();

            int sum = liquid + ingredient;
            int cooked = 0;
            switch (sum) {
                case 25:
                    cooked = integerMap.get("Biscuit") + 1;
                    integerMap.replace("Biscuit", cooked);
                    break;
                case 50:
                    cooked = integerMap.get("Cake") + 1;
                    integerMap.replace("Cake", cooked);
                    break;
                case 75:
                    cooked = integerMap.get("Pastry") + 1;
                    integerMap.replace("Pastry", cooked);
                    break;
                case 100:
                    cooked = integerMap.get("Pie") + 1;
                    integerMap.replace("Pie", cooked);
                    break;
            }
            if (sum != 25 && sum != 50 && sum != 75 && sum != 100) {
                liquids.pop();
                ingredients.pop();
                ingredients.push(ingredient + 3);
            } else {
                liquids.pop();
                ingredients.pop();

            }

        }

        boolean isCookedAll = integerMap.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (isCookedAll) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String leftLiquids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + leftLiquids);

        String leftIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + leftIngredients);

        for (var entry : integerMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
