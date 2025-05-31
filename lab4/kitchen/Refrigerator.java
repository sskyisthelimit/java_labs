package lab4.kitchen;
import lab4.base.ElectricAppliance;
import lab4.exceptions.InvalidParameterException;

import java.io.Serializable;

public class Refrigerator extends ElectricAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int temperature;

    public Refrigerator(String name, int powerConsumption, int temperature) throws InvalidParameterException {
        super(name, powerConsumption);

        if (temperature > 10) {
            throw new InvalidParameterException("Температура холодильника не повинна перевищувати 10°C");
        }

        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) throws InvalidParameterException {
        if (temperature > 10) {
            throw new InvalidParameterException("Температура холодильника не повинна перевищувати 10°C");
        }
        this.temperature = temperature;
        System.out.println(getName() + " встановлено температуру: " + temperature + "°C");
    }

    @Override
    public String toString() {
        return super.toString() + " [Температура: " + temperature + "°C]";
    }
}