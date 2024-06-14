package securityservice.util.constant;

public final class ResponseConstant {
    public static final class SuccessResponse {
        public static final String CODE = "200";
        public static final String MESSAGE = "Success";
    }

    public static final class ErrorResponse {
        public static final String BAD_REQUEST = "400";
        public static final String CONFLICT = "409";
        public static final String NOT_FOUND = "404";
    }

    public static final class UserConstant {
        public static final String USERNAME = "Username already exist.";
        public static final String ROLE = "The role does not exist.";
        public static final String USER_NOT_FOUND = "User not found.";
    }

    public static final class LoginUserConstant {
        public static final String CODE_INCORRECT = "401";
        public static final String PASSWORD = "Incorrect password.";
        public static final String USER_NOT_FOUND = "User not found.";
    }

    public static final class AvatarConstant {
        public static final String AVATAR_NOT_FOUND = "Avatar not found.";
    }
}
