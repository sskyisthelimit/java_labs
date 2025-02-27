package lab2;
import lab2.Circle;

public class Task1 {
    public static void main(String[] args) {
        Circle c = new Circle();

        System.out.println("Area: " + c.calcArea());
        c.setRadius(5);
        c.setCenterCoords(2, 3);

        System.out.println("Area: " + c.calcArea());
    }

}