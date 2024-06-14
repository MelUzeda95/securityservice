package securityservice.service.user;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.response.user.UserResponse;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.UserRepository;

import java.util.List;

@Service
@Scope(value = "prototype")
public class GetUsersService {
    private final UserRepository userRepository;

    private final ComposeUserResponse composeUserResponse;

    public GetUsersService(UserRepository userRepository, ComposeUserResponse composeUserResponse) {
        this.userRepository = userRepository;
        this.composeUserResponse = composeUserResponse;
    }

    public List<UserResponse> findByIds(List<Integer> userIds) {
        List<UserEntity> users = userRepository.findByIdInAndIsDeletedFalse(userIds);
        return composeUserResponse.composeUsers(users);
    }
}
