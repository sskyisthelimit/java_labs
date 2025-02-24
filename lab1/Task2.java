import java.util.Random;
import java.util.Scanner;

public class Task2 {
    /*
    Student ID number: 14308365
    C5 = 14308365 % 5 = 0
    C7 = 14308365 % 7 = 1
    C11 = 14308365 % 11 = 5
    operation for matrices: C5 = 0 -> C = a * B, a - const
    matrix element type: C7 = 1 -> byte
    function for matrix C: C11 = 5 ->
        sum of max(row) with odd indexes, min(row) with even indexes
     */
    public static short[][] generateRandomMatrix(short rows, short cols, short a, short b) {
        short[][] matrix = new short[rows][cols];
        Random random = new Random();
        for (short i = 0; i < rows; i++) {
            for (short j = 0; j < cols; j++) {
                matrix[i][j] = (short) random.nextInt(b - a + 1);
                matrix[i][j] += a;
            }
        }
        return matrix;
    }

    public static void printMatrix(short[][] matrix) {
        for (short[] row : matrix) {
            for (short element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }


    public static void matMultByAlpha(short[][] matrix, short alpha) {
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                matrix[i][j] *= alpha;
            }
        }
    }

    public static int secondTask2Operation(short[][] matrix) {
        int sum = 0;
        short row_index = 1;
        for (short[] row : matrix) {
            if (row_index % 2 == 1){
                short maxInRow = Short.MIN_VALUE;

                for (short num : row) {
                    if (num > maxInRow) {
                        maxInRow = num;
                    }
                }
                sum += maxInRow;
            } else if (row_index % 2 == 0){
                short minInRow = Short.MAX_VALUE;

                for (short num : row) {
                    if (num < minInRow) {
                        minInRow = num;
                    }
                }
                sum += minInRow;
            }
            row_index += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows for B: ");
        short rows = scanner.nextShort();

        System.out.print("Enter number of columns for B: ");
        short cols = scanner.nextShort();

        System.out.print("Enter lower bound (a) for short type elements: ");
        short a = scanner.nextShort();

        System.out.print("Enter upper bound (b) for short type elements: ");
        short b = scanner.nextShort();

        short[][] matrix = generateRandomMatrix(rows, cols, a, b);

        System.out.println("Initial generated matrix:");
        printMatrix(matrix);

        System.out.print("Enter short type mult. const a for operation C = a * B: ");
        short alpha = scanner.nextShort();

        matMultByAlpha(matrix, alpha);
        System.out.println("Matrix after multiplication by alpha:");

        printMatrix(matrix);

        int task2_result = secondTask2Operation(matrix);
        System.out.println("Result: " + task2_result);
        scanner.close();
    }
}