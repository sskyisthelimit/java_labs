package lab2;
public class Animal {
    private String name;
    private int age;
    private double weight;
    private String species;

    public Animal(String name, int age, double weight, String species) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Weight must be positive.");
        }
    }

    public String getSpecies() {
        return species;
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food);
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }

    public void displayInfo() {
        System.out.println("Animal Information:");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " kg");
    }
}
