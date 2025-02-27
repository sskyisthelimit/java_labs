package lab2;
import lab2.Circle;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle c = new Circle();
        System.out.println("Trying to calc. area without setting class prop.: ");
        System.out.println("Area: " + c.calcArea());
        System.out.println("Set circle radius:");

        float radius = scanner.nextFloat();
        c.setRadius(radius);

        System.out.println("Set x coord for circle:");
        float x_coord = scanner.nextFloat();

        System.out.println("Set y coord for circle:");
        float y_coord = scanner.nextFloat();

        c.setCenterCoords(x_coord, y_coord);

        System.out.println("Area: " + c.calcArea());
    }

}