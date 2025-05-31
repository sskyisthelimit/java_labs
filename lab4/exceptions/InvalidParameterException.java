package lab4.exceptions;

public class InvalidParameterException extends ApplianceException {
    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}

