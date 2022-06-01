import java.util.HashMap;
import java.util.Scanner;

public class DEmo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<HashMap<String, Integer>, HashMap<String, Integer>> bigmap = new HashMap<>();

        HashMap<String, Integer> countryMap = new HashMap<>();
        HashMap<String, Integer> cityMap = new HashMap<>();

        countryMap.put("Bulgaria", 0);
        countryMap.put("Uk", 0);
        cityMap.put("London", 4);
        cityMap.put("Sofia", 2);

        bigmap.put(countryMap, cityMap);

        for (var entry :
                bigmap.entrySet()) {
            var set1 = entry.getKey().entrySet();
            var set2 = entry.getValue().entrySet();
            for (var entryy :
                    set1) {
                System.out.println(entryy.getKey() + ": " + entryy.getValue());
                for (var city :
                        set2) {
                    System.out.println(city.getKey() + ": " + city.getValue());
                }
            }
        }
    }
}
