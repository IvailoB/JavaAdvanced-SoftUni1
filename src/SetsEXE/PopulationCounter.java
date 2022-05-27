package SetsEXE;

import StacksAndQueuesExe.ReverseNumber;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, TreeMap<String, Integer>> countyMap = new TreeMap<>();
        TreeMap<String, Integer> countryPopulationMap = new TreeMap<>();

        int totalPopulaiton = 0;
        while (!input.equals("report")) {
            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            int population = Integer.parseInt(data[2]);

            if (!countyMap.containsKey(country)) {
                countyMap.put(country, new TreeMap<>());
                countryPopulationMap.put(country, 0);
                totalPopulaiton = 0;
            }
            totalPopulaiton += population;
            if (countryPopulationMap.containsKey(country)) {
                countryPopulationMap.replace(country, totalPopulaiton);
            }


            var county = countyMap.get(country);
            if (!county.containsKey(city)) {
                county.put(city, population);
            }


            input = scanner.nextLine();
        }

        for (var entry : countyMap.entrySet()) {

            String country = entry.getKey();
            System.out.printf("%s (total population: %d)%n", entry.getKey(), totalPopulaiton);

            var cityInformation = entry.getValue();

            for (var e : cityInformation.entrySet()) {
                System.out.printf("=>%s: %d%n", e.getKey(), e.getValue());
            }
        }
    }
}
