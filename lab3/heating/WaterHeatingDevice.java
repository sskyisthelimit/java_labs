package lab3.heating;

import lab3.base.ElectricAppliance;

public class WaterHeatingDevice extends ElectricAppliance {
    private int waterCapacity; // у літрах
    private int maxTemperature; // у градусах Цельсія

    public WaterHeatingDevice(String name, int powerConsumption, int waterCapacity, int maxTemperature) {
        super(name, powerConsumption);
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