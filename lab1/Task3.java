import java.util.Scanner;

public class Task3 {

    public static int countSubstringOccurrences(String text, String substring) {
        text = text.toLowerCase();
        substring = substring.toLowerCase();

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public static String removeCharacters(String sentence, int n1, int n2) {
        if (n1 < 1 || n2 > sentence.length() || n1 > n2) {
            System.out.println("Неправильні індекси. Будь ласка, перевірте значення n1 та n2.");
            return sentence;
        }
        String before = sentence.substring(0, n1 - 1);
        String after = sentence.substring(n2);
        return before + after;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть довільний текст для пошуку буквосполучення \"то\":");
        String text = scanner.nextLine();
        int occurrences = countSubstringOccurrences(text, "то");
        System.out.println("Буквосполучення \"то\" зустрічається " + occurrences + " раз(и).");

        System.out.println("\nВведіть речення для видалення символів:");
        String sentence = scanner.nextLine();
        System.out.println("Введіть початкову позицію n1 (1-індексація):");
        int n1 = scanner.nextInt();
        System.out.println("Введіть кінцеву позицію n2 (1-індексація):");
        int n2 = scanner.nextInt();

        String modifiedSentence = removeCharacters(sentence, n1, n2);
        System.out.println("Речення після видалення символів:");
        System.out.println(modifiedSentence);

        scanner.close();
    }
}
