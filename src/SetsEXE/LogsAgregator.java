package SetsEXE;

import java.util.*;

public class LogsAgregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> userInfo = new TreeMap<>();
        List<String> ipAddresses = new ArrayList<>();
        TreeMap<Map<String, Integer>, List<String>> usersMap = new TreeMap();

        int totalDuration = 0;
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            String ip = data[0];
            String userName = data[1];
            int duration = Integer.parseInt(data[2]);


            if (!userInfo.containsKey(userName)) {
                userInfo.put(userName, duration);
            } else {
                userInfo.replace(userName, totalDuration);
            }
            if (!usersMap.containsKey(userInfo)) {

                totalDuration = 0;
                ipAddresses.clear();
                usersMap.put(userInfo, ip.lines().toList());
            } else {
                ipAddresses.add(ip);
                totalDuration += duration;
                usersMap.replace(userInfo, ipAddresses);
            }

        }

        //Print
        for (var entry : usersMap.entrySet()) {
            for (var e : userInfo.entrySet()) {
                System.out.printf("%s: %d %d", e.getKey(), e.getValue(), entry.getValue());
            }
        }
    }
}
