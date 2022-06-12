package ClassesEXE.PokemonTraner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Pokemon> pokemonList = new ArrayList<>();
        List<Trainer> trainerList = new ArrayList<>();

        Map<String, List<Pokemon>> trainerPokemonMap = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split(" ");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonList.add(pokemon);
            trainerPokemonMap.putIfAbsent(trainerName,pokemonList);

            Trainer trainer = new Trainer(trainerName, pokemonList);
            trainerList.add(trainer);
            trainerPokemonMap.putIfAbsent(trainerName, pokemonList);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        System.out.println();

        while (!input.equals("End")) {
            switch (input) {
                case "Fire":

                    break;
                case "Water":

                    break;
                case "Electricity":

                    break;
            }


            input = scanner.nextLine();
        }
    }
}
