package lab4.interfaces;
import lab4.exceptions.OperationException;

public interface Switchable {
    void turnOn() throws OperationException;
    void turnOff();
    boolean isOn();
}