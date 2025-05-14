package lab3.kitchen;

import java.util.Arrays;

public class ElectricStove extends KitchenAppliance {
    private int burners;
    private int[] currentBurnerPower;
    private boolean[] burnerStatus;

    public ElectricStove(String name, int powerConsumption, int burners) {
        super(name, powerConsumption);
        this.burners = burners;
        this.currentBurnerPower = new int[burners];
        this.burnerStatus = new boolean[burners];

        for (int i = 0; i < burners; i++) {
            currentBurnerPower[i] = getPowerConsumption() / burners;
            burnerStatus[i] = false;
        }
    }

    public int getBurners() {
        return burners;
    }

    public void setBurnerPower(int burner, int power) {
        if (burner >= 0 && burner < burners) {
            if (power >= 0 && power <= getPowerConsumption()) {
                currentBurnerPower[burner] = power;
                System.out.println(getName() + " встановлено потужність конфорки " + (burner + 1) + ": " + power + "Вт");
            } else {
                System.out.println("Неправильна потужність. Допустимий діапазон: 0-" + getPowerConsumption() + "Вт");
            }
        } else {
            System.out.println("Неправильний номер конфорки. Доступні конфорки: 1-" + burners);
        }
    }

    public void turnOnBurner(int burner) {
        if (burner >= 0 && burner < burners) {
            if (isOn()) {
                burnerStatus[burner] = true;
                System.out.println(getName() + " увімкнено конфорку " + (burner + 1));
            } else {
                System.out.println("Спершу увімкніть плиту!");
            }
        } else {
            System.out.println("Неправильний номер конфорки. Доступні конфорки: 1-" + burners);
        }
    }

    public void turnOffBurner(int burner) {
        if (burner >= 0 && burner < burners) {
            burnerStatus[burner] = false;
            System.out.println(getName() + " вимкнено конфорку " + (burner + 1));
        } else {
            System.out.println("Неправильний номер конфорки. Доступні конфорки: 1-" + burners);
        }
    }

    @Override
    public int getCurrentPowerUsage() {
        if (!isOn() || !isPluggedIn()) {
            return 0;
        }

        int totalUsage = 0;
        for (int i = 0; i < burners; i++) {
            if (burnerStatus[i]) {
                totalUsage += currentBurnerPower[i];
            }
        }
        return totalUsage;
    }

    @Override
    public String toString() {
        return super.toString() + " [Конфорок: " + burners + ", Активні конфорки: " +
                Arrays.toString(burnerStatus) + ", Поточне споживання: " + getCurrentPowerUsage() + "Вт]";
    }
}