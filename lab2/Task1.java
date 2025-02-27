package lab2;
import lab2.Circle;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle c = new Circle();

        System.out.println("Trying to calc. area without setting class prop.: ");
        System.out.println("Area: " + c.calcArea());

        System.out.println("--- Setting circle params ---");
        System.out.println("Set circle radius:");
        float radius = scanner.nextFloat();
        c.setRadius(radius);

        System.out.println("Set x coord for circle:");
        float x_coord = scanner.nextFloat();
        System.out.println("Set y coord for circle:");
        float y_coord = scanner.nextFloat();
        c.setCenterCoords(x_coord, y_coord);

        System.out.println("Area: " + c.calcArea());

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check if a point belongs to the circle");
            System.out.println("2. Exit the program");
            System.out.print("Enter your choice (1 or 2): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter x coordinate of the point:");
                    float pointX = scanner.nextFloat();
                    System.out.println("Enter y coordinate of the point:");
                    float pointY = scanner.nextFloat();

                    boolean belongs = c.doesPointBelong(pointX, pointY);
                    if (belongs) {
                        System.out.println("The point (" + pointX + ", " + pointY + ") belongs to the circle.");
                    } else {
                        System.out.println("The point (" + pointX + ", " + pointY + ") does not belong to the circle.");
                    }
                    break;

                case 2:
                    System.out.println("Exiting program. Goodbye!");
                    continueProgram = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    break;
            }
        }

        scanner.close();
    }
}