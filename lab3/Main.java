package lab3;

import lab3.base.Apartment;
import lab3.base.ElectricAppliance;
import lab3.entertainment.Television;
import lab3.heating.Boiler;
import lab3.kitchen.ElectricStove;
import lab3.kitchen.Microwave;
import lab3.kitchen.Refrigerator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створюємо апартаменти та наповнюємо їх приладами
        Apartment apartment = new Apartment();

        Refrigerator fridge = new Refrigerator("Холодильник Samsung", 200, 4);
        ElectricStove stove = new ElectricStove("Електроплита Gorenje", 2000, 4);
        Microwave microwave = new Microwave("Мікрохвильовка LG", 800, 1000);

        Television tv = new Television("Телевізор Sony", 120, 55);

        Boiler boiler = new Boiler("Бойлер Electrolux", 1500, 80, 75);

        // Додаємо прилади до квартири
        apartment.addAppliance(fridge);
        apartment.addAppliance(stove);
        apartment.addAppliance(microwave);
        apartment.addAppliance(tv);
        apartment.addAppliance(boiler);

        // Демонстрація роботи програми через консольне меню
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== СИСТЕМА КЕРУВАННЯ ЕЛЕКТРОПРИЛАДАМИ ===");
            System.out.println("1. Показати всі прилади");
            System.out.println("2. Підключити прилади до розетки");
            System.out.println("3. Увімкнути прилади");
            System.out.println("4. Показати підключені прилади");
            System.out.println("5. Показати працюючі прилади");
            System.out.println("6. Порахувати споживану потужність");
            System.out.println("7. Сортувати прилади за потужністю");
            System.out.println("8. Знайти прилади в діапазоні потужності");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllAppliances(apartment);
                    break;
                case 2:
                    plugInAppliances(apartment);
                    break;
                case 3:
                    turnOnAppliances(apartment);
                    break;
                case 4:
                    showPluggedInAppliances(apartment);
                    break;
                case 5:
                    showTurnedOnAppliances(apartment);
                    break;
                case 6:
                    showTotalPowerConsumption(apartment);
                    break;
                case 7:
                    sortByPowerConsumption(apartment);
                    break;
                case 8:
                    findAppliancesByPowerRange(apartment, scanner);
                    break;
                case 0:
                    System.out.println("Програма завершує роботу...");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void showAllAppliances(Apartment apartment) {
        System.out.println("\n=== ВСІ ПРИЛАДИ ===");
        List<ElectricAppliance> appliances = apartment.getAllAppliances();
        for (int i = 0; i < appliances.size(); i++) {
            System.out.println((i + 1) + ". " + appliances.get(i));
        }
    }

    private static void plugInAppliances(Apartment apartment) {
        System.out.println("\n=== ПІДКЛЮЧЕННЯ ПРИЛАДІВ ДО РОЗЕТКИ ===");
        List<ElectricAppliance> appliances = apartment.getAllAppliances();

        for (ElectricAppliance appliance : appliances) {
            appliance.plugIn();
            System.out.println(appliance.getName() + " підключено до розетки.");
        }
    }

    private static void turnOnAppliances(Apartment apartment) {
        System.out.println("\n=== УВІМКНЕННЯ ПРИЛАДІВ ===");
        List<ElectricAppliance> pluggedInAppliances = apartment.getPluggedInAppliances();

        for (ElectricAppliance appliance : pluggedInAppliances) {
            appliance.turnOn();
        }
    }

    private static void showPluggedInAppliances(Apartment apartment) {
        System.out.println("\n=== ПІДКЛЮЧЕНІ ПРИЛАДИ ===");
        List<ElectricAppliance> pluggedInAppliances = apartment.getPluggedInAppliances();

        if (pluggedInAppliances.isEmpty()) {
            System.out.println("Немає підключених приладів.");
        } else {
            for (int i = 0; i < pluggedInAppliances.size(); i++) {
                System.out.println((i + 1) + ". " + pluggedInAppliances.get(i));
            }
        }
    }

    private static void showTurnedOnAppliances(Apartment apartment) {
        System.out.println("\n=== ПРАЦЮЮЧІ ПРИЛАДИ ===");
        List<ElectricAppliance> turnedOnAppliances = apartment.getTurnedOnAppliances();

        if (turnedOnAppliances.isEmpty()) {
            System.out.println("Немає увімкнених приладів.");
        } else {
            for (int i = 0; i < turnedOnAppliances.size(); i++) {
                System.out.println((i + 1) + ". " + turnedOnAppliances.get(i));
            }
        }
    }

    private static void showTotalPowerConsumption(Apartment apartment) {
        System.out.println("\n=== ЗАГАЛЬНА СПОЖИВАНА ПОТУЖНІСТЬ ===");
        int totalPower = apartment.getTotalPowerConsumption();
        System.out.println("Загальна споживана потужність: " + totalPower + " Вт");
    }

    private static void sortByPowerConsumption(Apartment apartment) {
        System.out.println("\n=== СОРТУВАННЯ ЗА ПОТУЖНІСТЮ ===");
        apartment.sortByPowerConsumption();
        showAllAppliances(apartment);
    }

    private static void findAppliancesByPowerRange(Apartment apartment, Scanner scanner) {
        System.out.println("\n=== ПОШУК ПРИЛАДІВ ЗА ДІАПАЗОНОМ ПОТУЖНОСТІ ===");
        System.out.print("Мінімальна потужність (Вт): ");
        int minPower = scanner.nextInt();
        System.out.print("Максимальна потужність (Вт): ");
        int maxPower = scanner.nextInt();

        List<ElectricAppliance> foundAppliances = apartment.findAppliancesByPowerRange(minPower, maxPower);

        if (foundAppliances.isEmpty()) {
            System.out.println("Не знайдено приладів у діапазоні " + minPower + "-" + maxPower + " Вт");
        } else {
            System.out.println("Прилади в діапазоні " + minPower + "-" + maxPower + " Вт:");
            for (int i = 0; i < foundAppliances.size(); i++) {
                System.out.println((i + 1) + ". " + foundAppliances.get(i));
            }
        }
    }

}