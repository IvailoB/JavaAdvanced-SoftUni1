package ClassesEXE.RawData;

public class Cargo {
    private int weight;
    private String type;

    public Cargo(int cargoWeight, String cargoType) {
        this.weight = cargoWeight;
        this.type = cargoType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
