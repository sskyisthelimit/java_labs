package lab2;
import lab2.Animal;

public class Zebra extends Animal {
    private int numberOfStripes;
    private int numberOfBirths;

    private double dailyHayConsumption;

    public Zebra(String name, int age, double weight,
                 int numberOfStripes, int numberOfBirths) {
        super(name, age, weight, "Zebra");
        this.numberOfBirths = numberOfBirths;
        this.numberOfStripes = numberOfStripes;
        this.dailyHayConsumption = 5.0;
    }

    public int getNumberOfStripes() {
        return numberOfStripes;
    }

    public void setNumberOfStripes(int numberOfStripes) {
        if (numberOfStripes > 0) {
            this.numberOfStripes = numberOfStripes;
        } else {
            System.out.println("Number of stripes must be positive.");
        }
    }

    public int getNumberOfBirths() {
        return numberOfBirths;
    }

    public void setNumberOfBirths(int numberOfBirths) {
        if (numberOfBirths >= 0) {
            this.numberOfBirths = numberOfBirths;
        } else {
            System.out.println("Number of births cannot be negative.");
        }
    }

    public double getDailyHayConsumption() {
        return dailyHayConsumption;
    }

    public void setDailyHayConsumption(double dailyHayConsumption) {
        if (dailyHayConsumption > 0) {
            this.dailyHayConsumption = dailyHayConsumption;
        } else {
            System.out.println("Daily hay consumption must be positive.");
        }
    }

    public void provideCare(String careType) {
        System.out.println(getName() + " is receiving " + careType + " care");
    }

    public void feed(double hayAmount) {
        System.out.println(getName() + " is being fed " + hayAmount + " kg of hay");
        System.out.println("Standart daily hay consumption: " + hayAmount + " kg");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes a braying sound!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Zebra-specific Information:");
        System.out.println("Number of Stripes: " + numberOfStripes);
        System.out.println("Number of Births: " + numberOfBirths);
        System.out.println("Daily Hay Consumption: " + dailyHayConsumption + " kg");
    }
}
