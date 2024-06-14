package securityservice.service.avatar;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securityservice.api.response.user.UserResponse;
import securityservice.exception.UserNotFoundException;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.UserRepository;
import securityservice.service.user.ComposeUserResponse;
import securityservice.util.constant.ResponseConstant;

import java.util.Optional;

@Service
@Scope(value = "prototype")
public class UploadAvatarService {
    private final UserRepository userRepository;

    private final ComposeUserResponse composeUserResponse;

    public UploadAvatarService(UserRepository userRepository, ComposeUserResponse composeUserResponse) {
        this.userRepository = userRepository;
        this.composeUserResponse = composeUserResponse;
    }

    @Transactional
    public UserResponse upload(Integer userId, String avatarInBase64) {
        UserEntity userEntity = userIdExists(userId);
        userEntity.setAvatar(avatarInBase64);
        UserEntity save = userRepository.save(userEntity);
        return composeUserResponse.composeUser(save);
    }

    public UserEntity userIdExists(Integer userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException(ResponseConstant.UserConstant.USER_NOT_FOUND);
        }
    }
}
