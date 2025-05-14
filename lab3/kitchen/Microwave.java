package lab3.kitchen;

public class Microwave extends KitchenAppliance {
    private int maxPower;
    private int currentPower;

    public Microwave(String name, int powerConsumption, int maxPower) {
        super(name, powerConsumption);
        this.maxPower = maxPower;
        this.currentPower = powerConsumption;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setPower(int power) {
        if (power > 0 && power <= maxPower) {
            this.currentPower = power;
            super.setPowerConsumption(power);
            System.out.println(getName() + " встановлено потужність: " + power + "Вт");
        } else {
            System.out.println("Неправильна потужність. Допустимий діапазон: 1-" + maxPower + "Вт");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Макс. потужність: " + maxPower + "Вт, Поточна потужність: " + currentPower + "Вт]";
    }
}
