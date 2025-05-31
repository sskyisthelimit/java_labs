package lab4.base;
import lab4.interfaces.Switchable;
import lab4.exceptions.OperationException;

import java.io.Serializable;

public abstract class ElectricAppliance implements Switchable, Comparable<ElectricAppliance>, Serializable {
    private static final long serialVersionUID = 1L;

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
        System.out.println(name + " підключено до розетки.");
    }

    public void unplug() throws OperationException {
        if (isOn) {
            turnOff();
        }
        isPluggedIn = false;
        System.out.println(name + " відключено від розетки.");
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    @Override
    public void turnOn() throws OperationException {
        if (isPluggedIn) {
            isOn = true;
            System.out.println(name + " увімкнено.");
        } else {
            throw new OperationException(name + " не підключено до розетки. Спочатку підключіть пристрій.");
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ElectricAppliance that = (ElectricAppliance) obj;

        if (powerConsumption != that.powerConsumption) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 21* result + powerConsumption;
        return result;
    }
}