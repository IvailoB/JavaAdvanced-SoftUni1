package ClassesEXE.CarSalesmen;

public class Car {
    private String carModel;
    private Engine engine;
    private String color;
    private String weight;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.color = "n/a";
        this.weight = "n/a";
    }

    public Car(String carModel, Engine engine, String color) {
        this(carModel, engine);
        if (color.matches("//d+")) {
            this.weight = color;
        } else {
            this.color = color;
        }
    }

    public Car(String carModel, Engine engine, String color, String weight) {
        this(carModel, engine, color);
        this.weight = weight;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "%s:\n" +
                        "Power: %d\n" +
                        "Displacement: 28\n" +
                        "Efficiency: B\n" +
                        "Weight: %s\n" +
                        "Color: %s\n", this.carModel, this.engine.getEngineModel(),
                this.engine.getEnginePower(), this.engine.getDisplacement()
                , this.engine.getEfficiency(), this.weight, this.color);

    }
}
