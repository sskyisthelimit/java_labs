package lab3.base;

import lab3.interfaces.Switchable;

public abstract class ElectricAppliance implements Switchable, Comparable<ElectricAppliance> {
    private String name;
    private int powerConsumption; // у ватах
    private boolean isPluggedIn;
    private boolean isOn;

    public ElectricAppliance(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.isPluggedIn = false;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void plugIn() {
        isPluggedIn = true;
    }

    public void unplug() {
        isPluggedIn = false;
        if (isOn) {
            turnOff();
        }
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    @Override
    public void turnOn() {
        if (isPluggedIn) {
            isOn = true;
            System.out.println(name + " увімкнено.");
        } else {
            System.out.println(name + " не підключено до розетки.");
        }
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(name + " вимкнено.");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentPowerUsage() {
        return isOn && isPluggedIn ? powerConsumption : 0;
    }

    @Override
    public String toString() {
        return name + " (потужність: " + powerConsumption + "Вт, " +
                (isPluggedIn ? "підключено" : "не підключено") + ", " +
                (isOn ? "увімкнено" : "вимкнено") + ")";
    }

    @Override
    public int compareTo(ElectricAppliance other) {
        return Integer.compare(this.powerConsumption, other.powerConsumption);
    }
}