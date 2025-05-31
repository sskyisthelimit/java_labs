package lab4.base;

import lab4.exceptions.SerializationException;

import java.io.*;

public class ApartmentSerializer {

    public static void serializeApartment(Apartment apartment, String filePath) throws SerializationException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(apartment);
            System.out.println("Дані успішно збережено у файл: " + filePath);
        } catch (IOException e) {
            throw new SerializationException("Помилка при збереженні даних: " + e.getMessage(), e);
        }
    }

    public static Apartment deserializeApartment(String filePath) throws SerializationException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Apartment apartment = (Apartment) ois.readObject();
            System.out.println("Дані успішно завантажено з файлу: " + filePath);
            return apartment;
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException("Помилка при завантаженні даних: " + e.getMessage(), e);
        }
    }
}