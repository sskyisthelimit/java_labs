package lab4.heating;
import lab4.exceptions.InvalidParameterException;
import lab4.exceptions.OperationException;

import java.io.Serializable;

public class Boiler extends WaterHeatingDevice implements Serializable {
    private static final long serialVersionUID = 1L;

    private int currentTemperature;

    public Boiler(String name, int powerConsumption, int waterCapacity, int maxTemperature) throws InvalidParameterException {
        super(name, powerConsumption, waterCapacity, maxTemperature);
        this.currentTemperature = 20;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setTemperature(int temperature) throws InvalidParameterException {
        if (temperature >= 20 && temperature <= getMaxTemperature()) {
            this.currentTemperature = temperature;
            System.out.println(getName() + " встановлено температуру: " + temperature + "°C");
        } else {
            throw new InvalidParameterException("Неприпустима температура. Допустимий діапазон: 20-" + getMaxTemperature() + "°C");
        }
    }

    @Override
    public void turnOn() throws OperationException {
        super.turnOn();
        if (isOn()) {
            System.out.println(getName() + " починає нагрівати воду до " + currentTemperature + "°C.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Поточна температура: " + currentTemperature + "°C]";
    }
}