package lab2;
import lab2.Animal;

public class Tiger extends Animal {
    private double tailSize;
    private int numberOfVisitors;
    private boolean isInStudyProgram;
    private String[] compatibleAnimals;

    public Tiger(String name, int age, double weight,
                 double tailSize, int numberOfVisitors) {
        super(name, age, weight, "Tiger");
        this.tailSize = tailSize;
        this.numberOfVisitors = numberOfVisitors;
        this.isInStudyProgram = false;
        this.compatibleAnimals = new String[0];
    }

    public double getTailSize() {
        return tailSize;
    }

    public void setTailSize(double tailSize) {
        if (tailSize > 0) {
            this.tailSize = tailSize;
        } else {
            System.out.println("Tail size must be positive.");
        }
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(int numberOfVisitors) {
        if (numberOfVisitors >= 0) {
            this.numberOfVisitors = numberOfVisitors;
        } else {
            System.out.println("Number of visitors cannot be negative.");
        }
    }

    public boolean isInStudyProgram() {
        return isInStudyProgram;
    }

    public void enrollInStudyProgram(String studyName) {
        isInStudyProgram = true;
        System.out.println(getName() + " has been enrolled in the " + studyName + " study program");
    }

    public void receiveVisitors(int visitorCount) {
        numberOfVisitors += visitorCount;
        System.out.println(getName() + " received " + visitorCount + " visitors today");
        System.out.println("Total visitors this month: " + numberOfVisitors);
    }

    public void setCompatibleAnimals(String[] animals) {
        this.compatibleAnimals = animals;
        System.out.println(getName() + " has been assessed for animal interaction compatibility");
    }

    public void listCompatibleAnimals() {
        if (compatibleAnimals.length == 0) {
            System.out.println(getName() + " has no compatible animals for interaction yet");
            return;
        }

        System.out.println(getName() + " is compatible with the following animals:");
        for (String animal : compatibleAnimals) {
            System.out.println("- " + animal);
        }
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " GROWLS deeply!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tiger-specific Information:");
        System.out.println("Tail Size: " + tailSize + " meters");
        System.out.println("Number of Visitors: " + numberOfVisitors);
        System.out.println("In Study Program: " + (isInStudyProgram ? "Yes" : "No"));
        System.out.println("Compatible with " + compatibleAnimals.length + " other animals");
    }
}
