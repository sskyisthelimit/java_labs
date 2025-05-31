package lab4;

import lab4.base.Apartment;
import lab4.base.ElectricAppliance;
import lab4.exceptions.*;
import lab4.heating.Boiler;
import lab4.kitchen.ElectricStove;
import lab4.kitchen.Microwave;
import lab4.kitchen.Refrigerator;
import lab4.entertainment.Television;
import lab4.base.ApartmentSerializer;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DEFAULT_SAVE_FILE = "apartment.dat";
    private static Scanner scanner = new Scanner(System.in);
    private static Apartment apartment = new Apartment();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== Система управління електричними приладами в квартирі ===");

        while (running) {
            try {
                displayMainMenu();
                int choice = getIntInput("Виберіть опцію: ");

                switch (choice) {
                    case 1:
                        displayAppliancesList();
                        break;
                    case 2:
                        addApplianceMenu();
                        break;
                    case 3:
                        manageApplianceMenu();
                        break;
                    case 4:
                        saveToFile();
                        break;
                    case 5:
                        loadFromFile();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Програму завершено.");
                        break;
                    default:
                        System.out.println("Невірна опція. Спробуйте ще раз.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Введіть числове значення!");
                scanner.nextLine(); // очистити буфер введення
            } catch (Exception e) {
                System.out.println("Виникла помилка: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Головне меню ---");
        System.out.println("1. Переглянути список приладів");
        System.out.println("2. Додати прилад");
        System.out.println("3. Керувати приладами");
        System.out.println("4. Зберегти дані у файл");
        System.out.println("5. Завантажити дані з файлу");
        System.out.println("0. Вийти");
    }

    private static void displayAppliancesList() {
        System.out.println("\n--- Список приладів ---");

        if (apartment.getApplianceCount() == 0) {
            System.out.println("Список приладів порожній.");
            return;
        }

        int i = 1;
        for (ElectricAppliance appliance : apartment.getAllAppliances()) {
            System.out.println(i + ". " + appliance);
            i++;
        }

        System.out.println("\nЗагальне споживання енергії: " + apartment.getTotalPowerConsumption() + " Вт");
    }

    private static void addApplianceMenu() {
        System.out.println("\n--- Додати прилад ---");
        System.out.println("1. Бойлер");
        System.out.println("2. Електроплита");
        System.out.println("3. Мікрохвильова піч");
        System.out.println("4. Холодильник");
        System.out.println("5. Телевізор");
        System.out.println("0. Назад");

        int choice = getIntInput("Виберіть тип приладу: ");

        if (choice == 0) return;

        try {
            String name = getStringInput("Введіть назву приладу: ");
            int power = getIntInput("Введіть споживану потужність (Вт): ");

            ElectricAppliance appliance = null;

            switch (choice) {
                case 1: // Бойлер
                    int waterCapacity = getIntInput("Введіть об'єм води (л): ");
                    int maxTemp = getIntInput("Введіть максимальну температуру (°C): ");
                    appliance = new Boiler(name, power, waterCapacity, maxTemp);
                    break;

                case 2: // Електроплита
                    int burners = getIntInput("Введіть кількість конфорок: ");
                    appliance = new ElectricStove(name, power, burners);
                    break;

                case 3: // Мікрохвильова піч
                    int maxPower = getIntInput("Введіть максимальну потужність (Вт): ");
                    appliance = new Microwave(name, power, maxPower);
                    break;

                case 4: // Холодильник
                    int temperature = getIntInput("Введіть температуру (°C): ");
                    appliance = new Refrigerator(name, power, temperature);
                    break;

                case 5: // Телевізор
                    int screenSize = getIntInput("Введіть розмір екрану (дюйми): ");
                    appliance = new Television(name, power, screenSize);
                    break;

                default:
                    System.out.println("Невірний вибір типу приладу.");
                    return;
            }

            apartment.addAppliance(appliance);
            System.out.println("Прилад \"" + name + "\" успішно додано.");

        } catch (InvalidParameterException e) {
            System.out.println("Помилка при додаванні приладу: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    private static void manageApplianceMenu() {
        if (apartment.getApplianceCount() == 0) {
            System.out.println("Список приладів порожній.");
            return;
        }

        System.out.println("\n--- Керування приладами ---");
        displayAppliancesList();

        String name = getStringInput("Введіть назву приладу для керування (або 'назад' для повернення): ");

        if (name.equalsIgnoreCase("назад")) {
            return;
        }

        ElectricAppliance appliance = apartment.findApplianceByName(name);

        if (appliance == null) {
            System.out.println("Прилад з назвою \"" + name + "\" не знайдено.");
            return;
        }

        manageSpecificAppliance(appliance);
    }

    private static void manageSpecificAppliance(ElectricAppliance appliance) {
        boolean managing = true;

        while (managing) {
            System.out.println("\n--- Керування приладом \"" + appliance.getName() + "\" ---");
            System.out.println("1. Підключити до розетки");
            System.out.println("2. Відключити від розетки");
            System.out.println("3. Увімкнути");
            System.out.println("4. Вимкнути");

            // Специфічні опції в залежності від типу приладу
            if (appliance instanceof Boiler) {
                System.out.println("5. Встановити температуру");
            } else if (appliance instanceof ElectricStove) {
                System.out.println("5. Керувати конфорками");
            } else if (appliance instanceof Microwave) {
                System.out.println("5. Встановити потужність");
            } else if (appliance instanceof Refrigerator) {
                System.out.println("5. Встановити температуру");
            } else if (appliance instanceof Television) {
                System.out.println("5. Змінити канал");
            }

            System.out.println("0. Назад");

            int choice = getIntInput("Виберіть опцію: ");

            try {
                switch (choice) {
                    case 1:
                        appliance.plugIn();
                        break;
                    case 2:
                        appliance.unplug();
                        break;
                    case 3:
                        appliance.turnOn();
                        break;
                    case 4:
                        appliance.turnOff();
                        break;
                    case 5:
                        manageSpecificFunction(appliance);
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                        System.out.println("Невірна опція. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void manageSpecificFunction(ElectricAppliance appliance) throws Exception {
        if (appliance instanceof Boiler) {
            Boiler boiler = (Boiler) appliance;
            int temp = getIntInput("Введіть бажану температуру (20-" + boiler.getMaxTemperature() + "°C): ");
            boiler.setTemperature(temp);
        } else if (appliance instanceof ElectricStove) {
            manageStove((ElectricStove) appliance);
        } else if (appliance instanceof Microwave) {
            Microwave microwave = (Microwave) appliance;
            int power = getIntInput("Введіть бажану потужність (1-" + microwave.getMaxPower() + "Вт): ");
            microwave.setPower(power);
        } else if (appliance instanceof Refrigerator) {
            Refrigerator refrigerator = (Refrigerator) appliance;
            int temp = getIntInput("Введіть бажану температуру (не більше 10°C): ");
            refrigerator.setTemperature(temp);
        } else if (appliance instanceof Television) {
            Television tv = (Television) appliance;
            int channel = getIntInput("Введіть номер каналу: ");
            tv.setChannel(channel);
        }
    }

    private static void manageStove(ElectricStove stove) {
        System.out.println("\n--- Керування конфорками ---");
        System.out.println("1. Увімкнути конфорку");
        System.out.println("2. Вимкнути конфорку");
        System.out.println("3. Встановити потужність конфорки");
        System.out.println("0. Назад");

        int choice = getIntInput("Виберіть опцію: ");

        if (choice == 0) return;

        try {
            int burner = getIntInput("Введіть номер конфорки (1-" + stove.getBurners() + "): ") - 1;

            switch (choice) {
                case 1:
                    stove.turnOnBurner(burner);
                    break;
                case 2:
                    stove.turnOffBurner(burner);
                    break;
                case 3:
                    int power = getIntInput("Введіть потужність (Вт): ");
                    stove.setBurnerPower(burner, power);
                    break;
                default:
                    System.out.println("Невірна опція.");
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void saveToFile() {
        try {
            System.out.println("\n--- Збереження даних ---");
            String fileName = getStringInput("Введіть ім'я файлу (або Enter для стандартного " + DEFAULT_SAVE_FILE + "): ");

            if (fileName.isEmpty()) {
                fileName = DEFAULT_SAVE_FILE;
            }

            if (!fileName.endsWith(".dat")) {
                fileName += ".dat";
            }

            ApartmentSerializer.serializeApartment(apartment, fileName);
        } catch (SerializationException e) {
            System.out.println("Помилка при збереженні: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try {
            System.out.println("\n--- Завантаження даних ---");

            File directory = new File(".");
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".dat"));

            if (files == null || files.length == 0) {
                System.out.println("Файлів для завантаження не знайдено.");
                return;
            }

            System.out.println("Доступні файли:");
            for (File file : files) {
                System.out.println("- " + file.getName());
            }

            String fileName = getStringInput("Введіть ім'я файлу (або Enter для стандартного " + DEFAULT_SAVE_FILE + "): ");

            if (fileName.isEmpty()) {
                fileName = DEFAULT_SAVE_FILE;
            }

            if (!fileName.endsWith(".dat")) {
                fileName += ".dat";
            }

            apartment = ApartmentSerializer.deserializeApartment(fileName);
            System.out.println("Завантажено " + apartment.getApplianceCount() + " приладів.");
        } catch (SerializationException e) {
            System.out.println("Помилка при завантаженні: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // очистити буфер введення
            return value;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // очистити буфер введення
            throw e;
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}