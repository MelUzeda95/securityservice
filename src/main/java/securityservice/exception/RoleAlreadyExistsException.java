package securityservice.exception;

public class RoleAlreadyExistsException extends RuntimeException{

    public RoleAlreadyExistsException(String message){
        super(message);
    }

    public RoleAlreadyExistsException(Throwable cause){
        super(cause);
    }

    public RoleAlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
