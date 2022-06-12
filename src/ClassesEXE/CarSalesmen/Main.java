package ClassesEXE.CarSalesmen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < countEngines; i++) {
            String[] engineInfo = scanner.nextLine().split(" ");

            String engineModel = engineInfo[0];
            int enginePower = Integer.parseInt(engineInfo[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            Engine engine = null;
            switch (engineInfo.length) {
                case 4:
                    displacement = engineInfo[2];
                    efficiency = engineInfo[3];
                    engine = new Engine(engineModel, enginePower, displacement, efficiency);
                    break;
                case 3:
                    if (engineInfo[2].matches("\\d+")) {
                        displacement = engineInfo[2];
                        engine = new Engine(engineModel, enginePower, displacement);
                    } else {
                        efficiency = engineInfo[2];
                        engine = new Engine(engineModel, enginePower, efficiency);
                    }
                    break;
            }
            engineList.add(engine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < countCars; i++) {
            String[] carsInfo = scanner.nextLine().split(" ");

            String carModel = carsInfo[0];
            String engineName = carsInfo[1];
            Car car = null;

            boolean isExistEngine = engineList.stream().anyMatch(engine -> engine.getEngineModel().equals(engineName));


            String weight = "n/a";
            String color = "n/a";


            switch (carsInfo.length) {
                case 2:

                    break;
                case 3:
                    if (carsInfo[2].matches("\\d+")) {
                        weight = carsInfo[2];

                    } else {
                        color = carsInfo[2];
                    }
                    break;
                case 4:
                    weight = carsInfo[2];
                    color = carsInfo[3];
                    break;
            }


        }

    }

}
