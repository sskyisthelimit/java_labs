package lab3.heating;

public class Boiler extends WaterHeatingDevice {
    private int currentTemperature;

    public Boiler(String name, int powerConsumption, int waterCapacity, int maxTemperature) {
        super(name, powerConsumption, waterCapacity, maxTemperature);
        this.currentTemperature = 20;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setTemperature(int temperature) {
        if (temperature >= 20 && temperature <= getMaxTemperature()) {
            this.currentTemperature = temperature;
            System.out.println(getName() + " встановлено температуру: " + temperature + "°C");
        } else {
            System.out.println("Неприпустима температура. Допустимий діапазон: 20-" + getMaxTemperature() + "°C");
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        if (isOn()) {
            System.out.println(getName() + " починає нагрівати воду до " + currentTemperature + "°C.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Поточна температура: " + currentTemperature + "°C" + ", поточна потужність: " + super.getPowerConsumption() + "Вт";
    }
}