package securityservice.service.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.user.LoginUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.exception.IncorrectLoginException;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.UserRepository;
import securityservice.util.constant.ResponseConstant;

import java.util.Optional;

@Service
@Scope(value = "prototype")
public class LoginUserService {
    private final UserRepository userRepository;

    private final ComposeUserResponse composeUserResponse;

    public LoginUserService(UserRepository userRepository, ComposeUserResponse composeUserResponse) {
        this.userRepository = userRepository;
        this.composeUserResponse = composeUserResponse;
    }

    public UserResponse login(LoginUserRequest request) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(request.getUsername());
        if (userEntity.isPresent()) {
            UserEntity userFound = userEntity.get();
            String databasePassword = userFound.getPassword();
            String passwordEntered = request.getPassword();
            if (checkPassword(passwordEntered, databasePassword)) {
                UserResponse user = composeUserResponse.composeUser(userFound);
                return user;
            } else {
                throw new IncorrectLoginException(ResponseConstant.LoginUserConstant.PASSWORD);
            }
        } else {
            throw new IncorrectLoginException(ResponseConstant.LoginUserConstant.USER_NOT_FOUND);
        }
    }

    private Boolean checkPassword(String passwordEntered, String hashedPassword) {
        return BCrypt.checkpw(passwordEntered, hashedPassword);
    }
}
