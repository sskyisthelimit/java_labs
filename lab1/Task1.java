import java.util.Scanner;

public class Task1 {
    /*
    Student ID number: 14308365
    C2 = 14308365 % 2 = 1
    C3 = 14308365 % 3 = 0
    C5 = 14308365 % 5 = 0
    C7 = 14308365 % 7 = 1
    O1: substraction operation (a, b) -> a - b
    C = C3 = 0
    O2: multiplication operation (a, b) -> a * b
    i, j type: C7 = 1 -> short

     */
    public static double computeSum(short a, short b, short C, short n) {
        double sum = 0.0;
        for (short i = a; i <= n; i++){
            if (i - C == 0) {
                System.out.println("Division by zero for i = " + i + ". Skipping this iteration.");
                continue;
            }
            for (short j = b; j <= n; j++) {
                sum += (double)(i * j) / (i - C);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short C = 0;

        System.out.print("Enter value for a: ");
        short a = scanner.nextShort();

        System.out.print("Enter value for b: ");
        short b = scanner.nextShort();

        System.out.print("Enter value for n: ");
        short n = scanner.nextShort();

        double result = computeSum(a, b, C, n);

        System.out.println("Result: " + result);
        scanner.close();
    }
}
