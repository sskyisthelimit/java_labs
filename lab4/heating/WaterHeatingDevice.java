package lab4.heating;
import lab4.base.ElectricAppliance;
import lab4.exceptions.InvalidParameterException;

import java.io.Serializable;

public abstract class WaterHeatingDevice extends ElectricAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int waterCapacity; // у літрах
    private int maxTemperature; // у градусах Цельсія

    public WaterHeatingDevice(String name, int powerConsumption, int waterCapacity, int maxTemperature)
            throws InvalidParameterException {
        super(name, powerConsumption);

        if (waterCapacity <= 0) {
            throw new InvalidParameterException("Об'єм води повинен бути більше 0 літрів");
        }
        if (maxTemperature <= 20) {
            throw new InvalidParameterException("Максимальна температура повинна бути більше 20°C");
        }

        this.waterCapacity = waterCapacity;
        this.maxTemperature = maxTemperature;
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    @Override
    public String toString() {
        return super.toString() + " [Об'єм води: " + waterCapacity + "л, Макс. температура: " + maxTemperature + "°C]";
    }
}
