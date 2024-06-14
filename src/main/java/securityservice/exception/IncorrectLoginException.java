package securityservice.exception;

public class IncorrectLoginException extends RuntimeException {
    public IncorrectLoginException(String message) {
        super(message);
    }

    public IncorrectLoginException(Throwable cause) {
        super(cause);
    }

    public IncorrectLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
