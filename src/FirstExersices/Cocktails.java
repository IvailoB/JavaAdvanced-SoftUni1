package FirstExersices;

import java.util.*;
import java.util.stream.Collectors;

public class Cocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(freshnessLevel::push);

        Map<String, Integer> integersMap = new TreeMap<>();

        integersMap.put("Pear Sour", 0);
        integersMap.put("The Harvest", 0);
        integersMap.put("Apple Hinny", 0);
        integersMap.put("High Fashion", 0);

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            Integer ingredient = ingredients.peek();
            Integer freshness = freshnessLevel.peek();

            if (ingredient == 0) {
                ingredients.pop();
                continue;
            }
            int multiplication = ingredient * freshness;
            String madeCocktail;
            switch (multiplication) {
                case 150:
                    madeCocktail = "Pear Sour";
                    break;
                case 250:
                    madeCocktail = "The Harvest";
                    break;
                case 300:
                    madeCocktail = "Apple Hinny";
                    break;
                case 400:
                    madeCocktail = "High Fashion";
                    break;
                default:
                    madeCocktail = null;
                    break;
            }
            if (madeCocktail != null) {
                int countOfCocktails = integersMap.get(madeCocktail) + 1;
                integersMap.put(madeCocktail, countOfCocktails);
                if (countOfCocktails == 4) {
                    break;
                }
                ingredients.pop();
                freshnessLevel.pop();
            } else {
                freshnessLevel.pop();
                ingredient += 5;
                ingredients.pop();
                ingredients.add(ingredient);
            }
        }

        boolean allCocktailsPrepare = integersMap.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (allCocktailsPrepare) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            Integer leftIngredients = ingredients.stream()
                            .reduce(0,Integer::sum);



            System.out.println("Ingredients left: " + leftIngredients);
        }

        for (var entry : integersMap.entrySet()) {
            if (entry.getValue() != 0){
                System.out.printf(" # %s --> %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
