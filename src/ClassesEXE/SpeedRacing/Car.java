package ClassesEXE.SpeedRacing;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer, and distance traveled
    private String model;
    private double fuelAmount;
    private double consumption;
    private int distance;

    public Car(String model, double fuelAmount, double consumption) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean hasEnoughFuel(int kilometres) {
        double fuelNeeded = kilometres * consumption;
        return fuelAmount >= fuelNeeded;
    }

    public void drive(int kilometres) {
        double fuelNeeded = kilometres * consumption;
        fuelAmount -= fuelNeeded;
        distance+=kilometres;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model,this.fuelAmount,this.distance);
    }
}
