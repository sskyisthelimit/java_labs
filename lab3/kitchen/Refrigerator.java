package lab3.kitchen;

public class Refrigerator extends KitchenAppliance {
    private int temperature;

    public Refrigerator(String name, int powerConsumption, int temperature) {
        super(name, powerConsumption);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getName() + " встановлено температуру: " + temperature + "°C");
    }

    @Override
    public String toString() {
        return super.toString() + " [Температура: " + temperature + "°C]";
    }
}