package ClassesEXE.CarSalesmen;

public class Engine {
    private String engineModel;
    private int enginePower;
    private String displacement;
    private String efficiency;


    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, String efficiency) {
        this(engineModel, enginePower);
        if (efficiency.matches("\\d+")) {
            this.displacement = efficiency;
        } else {
            this.efficiency = efficiency;
        }
    }


    public Engine(String engineModel, int enginePower, String displacement, String efficiency) {
        this(engineModel, enginePower, displacement);
        this.efficiency = efficiency;
    }


    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

}
