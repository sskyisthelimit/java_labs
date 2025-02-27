package lab2;
import lab2.Animal;
public class Lion extends Animal {
    private int dailyMeatConsumptionKg;
    private int numberOfTrips;
    private double enclosureTemperature;

    // Constructor
    public Lion(String name, int age, double weight,
                int dailyMeatConsumptionKg, int numberOfTrips) {
        super(name, age, weight, "Lion");
        this.dailyMeatConsumptionKg = dailyMeatConsumptionKg;
        this.numberOfTrips = numberOfTrips;
        this.enclosureTemperature = 25.0; // Default enclosure temperature in Celsius
    }

    public int getDailyMeatConsumptionKg() {
        return dailyMeatConsumptionKg;
    }

    public void setDailyMeatConsumptionKg(int dailyMeatConsumptionKg) {
        if (dailyMeatConsumptionKg > 0) {
            this.dailyMeatConsumptionKg = dailyMeatConsumptionKg;
        } else {
            System.out.println("Meat consumption must be positive.");
        }
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        if (numberOfTrips >= 0) {
            this.numberOfTrips = numberOfTrips;
        } else {
            System.out.println("Number of trips cannot be negative.");
        }
    }

    public double getEnclosureTemperature() {
        return enclosureTemperature;
    }

    public void regulateEnclosureTemperature(double newTemperature) {
        if (newTemperature >= 20 && newTemperature <= 30) {
            this.enclosureTemperature = newTemperature;
            System.out.println(getName() + "'s enclosure temperature set to " + newTemperature + "°C");
        } else {
            System.out.println("Temperature must be between 20°C and 30°C for lion enclosures.");
        }
    }

    public void feed(int meatAmount) {
        System.out.println(getName() + " is being fed " + meatAmount + " kg of meat");
        System.out.println("Standart daily consumption: " + dailyMeatConsumptionKg + " kg");
    }

    public void takeTrip(String destination) {
        numberOfTrips++;
        System.out.println(getName() + " is taking a trip to " + destination);
        System.out.println("Total trips this year: " + numberOfTrips);
    }

    // Override parent methods
    @Override
    public void makeSound() {
        System.out.println(getName() + " ROARS loudly!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Lion-specific Information:");
        System.out.println("Meat Consumption: " + dailyMeatConsumptionKg + " kg");
        System.out.println("Number of Trips: " + numberOfTrips);
        System.out.println("Enclosure Temperature: " + enclosureTemperature + "°C");
    }
}