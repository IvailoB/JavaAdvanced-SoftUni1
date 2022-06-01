package SetsEXE;

import java.util.*;
public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, TreeMap<String, Integer>> countyMap = new TreeMap<>(Collections.reverseOrder());
        TreeMap<String, Integer> countryPopulationMap = new TreeMap<>(Collections.reverseOrder());

        int totalPopulation = 0;
        while (!input.equals("report")) {
            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            int population = Integer.parseInt(data[2]);

            if (!countyMap.containsKey(country)) {
                countyMap.put(country, new TreeMap<>());
                countryPopulationMap.put(country, 0);
                totalPopulation = 0;
            }
            totalPopulation += population;
            if (countryPopulationMap.containsKey(country)) {
                countryPopulationMap.replace(country, totalPopulation);
            }


            var county = countyMap.get(country);
            if (!county.containsKey(city)) {
                county.put(city, population);
            }


            input = scanner.nextLine();
        }

        for (var entry : countyMap.entrySet()) {

            String country = entry.getKey();
            System.out.printf("%s (total population: %d)%n", entry.getKey(), countryPopulationMap.get(country));

            var cityInformation = entry.getValue();

            for (var e : cityInformation.entrySet()) {
                System.out.printf("=>%s: %d%n", e.getKey(), e.getValue());
            }
        }
    }
}
