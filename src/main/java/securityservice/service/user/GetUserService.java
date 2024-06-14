package securityservice.service.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.response.user.UserResponse;
import securityservice.exception.UserNotFoundException;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.UserRepository;
import securityservice.util.constant.ResponseConstant;

import java.util.Optional;

@Service
@Scope(value = "prototype")
public class GetUserService {

    private final UserRepository userRepository;

    private final ComposeUserResponse composeUserResponse;

    public GetUserService(UserRepository userRepository, ComposeUserResponse composeUserResponse) {
        this.userRepository = userRepository;
        this.composeUserResponse = composeUserResponse;
    }

    public UserResponse findById(Integer id) throws UserNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            return composeUserResponse.composeUser(userEntity.get());
        } else {
            throw new UserNotFoundException(ResponseConstant.UserConstant.USER_NOT_FOUND);
        }
    }
}
