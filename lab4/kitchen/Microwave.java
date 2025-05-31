package lab4.kitchen;
import lab4.base.ElectricAppliance;
import lab4.exceptions.InvalidParameterException;

import java.io.Serializable;

public class Microwave extends ElectricAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int maxPower;
    private int currentPower;

    public Microwave(String name, int powerConsumption, int maxPower) throws InvalidParameterException {
        super(name, powerConsumption);

        if (maxPower <= 0) {
            throw new InvalidParameterException("Максимальна потужність повинна бути більше 0");
        }

        this.maxPower = maxPower;
        this.currentPower = maxPower / 2;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setPower(int power) throws InvalidParameterException {
        if (power <= 0 || power > maxPower) {
            throw new InvalidParameterException("Потужність повинна бути в діапазоні 1-" + maxPower + " Вт");
        }
        this.currentPower = power;
        System.out.println(getName() + " встановлено потужність: " + power + " Вт");
    }

    @Override
    public int getCurrentPowerUsage() {
        return isOn() && isPluggedIn() ? currentPower : 0;
    }

    @Override
    public String toString() {
        return super.toString() + " [Макс. потужність: " + maxPower + "Вт, Поточна: " + currentPower + "Вт]";
    }
}


