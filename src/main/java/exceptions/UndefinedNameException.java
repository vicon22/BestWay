package exceptions;

public class UndefinedNameException extends RuntimeException {

    public UndefinedNameException() {
    }

    public UndefinedNameException(String message) {
        super(message);
    }
}
