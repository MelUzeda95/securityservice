package securityservice.exception;

public class UsernameFoundException extends RuntimeException {
    public UsernameFoundException(String message) {
        super(message);
    }

    public UsernameFoundException(Throwable cause) {
        super(cause);
    }

    public UsernameFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
