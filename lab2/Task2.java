package lab2;
import lab2.Tiger;
import lab2.Animal;
import lab2.Zebra;
import lab2.Lion;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("===== Creating Lion =====");
        Lion leo = new Lion("Leo", 5, 190.5, 25, 2);
        leo.displayInfo();
        leo.makeSound();
        leo.feed(8);
        leo.regulateEnclosureTemperature(28.5);
        leo.takeTrip("Veterinary Clinic");


        System.out.println("\n===== Creating Tiger =====");
        Tiger torao = new Tiger("Torao", 4, 220.0, 0.9, 150);
        torao.displayInfo();
        torao.makeSound();
        torao.receiveVisitors(45);
        torao.enrollInStudyProgram("Tiger Behavior Research");
        torao.setCompatibleAnimals(new String[]{"Peacock", "Turtle"});
        torao.listCompatibleAnimals();

        System.out.println("\n===== Creating Zebra =====");
        Zebra shima = new Zebra("Shima", 3, 350.0, 80, 0);
        shima.displayInfo();
        shima.makeSound();
        shima.provideCare("Grooming");
        shima.feed(6.5);

        System.out.println("\n===== Demonstrating Polymorphism =====");
        Animal[] zooAnimals = {leo, torao, shima};
        List<String> carnivores = List.of("Lion", "Tiger");

        for (Animal animal : zooAnimals) {
            System.out.println("\nUsing an Animal reference to access " + animal.getName() + ":");
            animal.displayInfo();
            animal.makeSound();
            animal.eat(carnivores.contains(animal.getSpecies()) ? "meat" : "plants");
            animal.sleep();
        }
    }
}

