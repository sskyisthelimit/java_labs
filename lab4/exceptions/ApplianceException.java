package lab4.exceptions;

public class ApplianceException extends Exception {
    public ApplianceException(String message) {
        super(message);
    }

    public ApplianceException(String message, Throwable cause) {
        super(message, cause);
    }
}
