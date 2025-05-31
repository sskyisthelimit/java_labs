package lab4.kitchen;
import lab4.base.ElectricAppliance;
import lab4.exceptions.InvalidParameterException;
import lab4.exceptions.OperationException;

import java.io.Serializable;

public class ElectricStove extends ElectricAppliance implements Serializable {
    private static final long serialVersionUID = 1L;

    private int burners;
    private boolean[] burnerStates;
    private int[] burnerPowers;

    public ElectricStove(String name, int powerConsumption, int burners) throws InvalidParameterException {
        super(name, powerConsumption);

        if (burners <= 0) {
            throw new InvalidParameterException("Кількість конфорок повинна бути більше 0");
        }

        this.burners = burners;
        this.burnerStates = new boolean[burners];
        this.burnerPowers = new int[burners];
    }

    public int getBurners() {
        return burners;
    }

    public void turnOnBurner(int burnerIndex) throws InvalidParameterException, OperationException {
        if (!isOn()) {
            throw new OperationException("Спочатку увімкніть плиту");
        }
        if (burnerIndex < 0 || burnerIndex >= burners) {
            throw new InvalidParameterException("Неправильний номер конфорки");
        }
        burnerStates[burnerIndex] = true;
        System.out.println("Конфорка " + (burnerIndex + 1) + " увімкнена");
    }

    public void turnOffBurner(int burnerIndex) throws InvalidParameterException {
        if (burnerIndex < 0 || burnerIndex >= burners) {
            throw new InvalidParameterException("Неправильний номер конфорки");
        }
        burnerStates[burnerIndex] = false;
        System.out.println("Конфорка " + (burnerIndex + 1) + " вимкнена");
    }

    public void setBurnerPower(int burnerIndex, int power) throws InvalidParameterException {
        if (burnerIndex < 0 || burnerIndex >= burners) {
            throw new InvalidParameterException("Неправильний номер конфорки");
        }
        if (power < 0) {
            throw new InvalidParameterException("Потужність не може бути від'ємною");
        }
        burnerPowers[burnerIndex] = power;
        System.out.println("Потужність конфорки " + (burnerIndex + 1) + " встановлено на " + power + " Вт");
    }

    @Override
    public int getCurrentPowerUsage() {
        if (!isOn() || !isPluggedIn()) return 0;

        int totalPower = 0;
        for (int i = 0; i < burners; i++) {
            if (burnerStates[i]) {
                totalPower += burnerPowers[i] > 0 ? burnerPowers[i] : getPowerConsumption() / burners;
            }
        }
        return totalPower;
    }

    @Override
    public String toString() {
        return super.toString() + " [Конфорки: " + burners + "]";
    }
}
