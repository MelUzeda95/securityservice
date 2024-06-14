package securityservice.service.avatar;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import securityservice.exception.ProcessErrorException;
import securityservice.exception.UserNotFoundException;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.UserRepository;
import securityservice.util.constant.ResponseConstant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Optional;

@Service
@Scope(value = "prototype")
public class GetAvatarService {

    private final UserRepository userRepository;

    private final ResourceLoader resourceLoader;

    public GetAvatarService(UserRepository userRepository, ResourceLoader resourceLoader) {
        this.userRepository = userRepository;
        this.resourceLoader = resourceLoader;
    }

    public byte[] findById(Integer userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            String avatar = user.get().getAvatar();
            if (avatar != null) {
                return Base64.getDecoder().decode(avatar);
            } else {
                return defaultAvatar();
            }
        } else {
            throw new UserNotFoundException(ResponseConstant.AvatarConstant.AVATAR_NOT_FOUND);
        }
    }

    private byte[] defaultAvatar() {
        try {
            Resource resource = resourceLoader.getResource("classpath:user-avatar.png");
            InputStream inputStream = resource.getInputStream();
            return inputStream.readAllBytes();
        } catch (IOException e) {
            throw new ProcessErrorException("Error processing avatar");
        }
    }
}
