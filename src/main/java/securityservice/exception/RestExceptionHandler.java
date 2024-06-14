package securityservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import securityservice.util.constant.ResponseConstant;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseBody
    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleRoleNotFoundException(RoleNotFoundException exception) {
        log.error("RoleNotFoundException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.ErrorResponse.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    @ResponseBody
    @ExceptionHandler(UsernameFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleUsernameFoundException(UsernameFoundException exception) {
        log.error("UsernameFoundException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.ErrorResponse.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    @ResponseBody
    @ExceptionHandler(IncorrectLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleIncorrectLoginException(IncorrectLoginException exception) {
        log.error("IncorrectLoginException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.LoginUserConstant.CODE_INCORRECT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    @ResponseBody
    @ExceptionHandler(RoleAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleRoleAlreadyExistsException(RoleAlreadyExistsException exception) {
        log.error("RoleAlreadyExistsException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.ErrorResponse.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.error("UserNotFoundException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.ErrorResponse.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }

    @ResponseBody
    @ExceptionHandler(ProcessErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleProcessErrorException(ProcessErrorException exception) {
        log.error("ProcessErrorException: {}", exception.getMessage());
        ErrorResponse errorInfo = new ErrorResponse(ResponseConstant.ErrorResponse.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }
}