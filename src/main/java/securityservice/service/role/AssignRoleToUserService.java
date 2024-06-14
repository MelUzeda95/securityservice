package securityservice.service.role;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.role.AssignRoleToUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.exception.RoleNotFoundException;
import securityservice.exception.UserNotFoundException;
import securityservice.model.domain.Audit;
import securityservice.model.domain.RoleEntity;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.RoleRepository;
import securityservice.model.repository.UserRepository;
import securityservice.service.user.ComposeUserResponse;
import securityservice.util.constant.ResponseConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(value = "prototype")
public class AssignRoleToUserService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final ComposeUserResponse composeUserResponse;

    public AssignRoleToUserService(RoleRepository roleRepository, UserRepository userRepository, ComposeUserResponse composeUserResponse) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.composeUserResponse = composeUserResponse;
    }

    public UserResponse assignRoleToUser(AssignRoleToUserRequest request) {
        List<Audit> listEntities = validation(request);
        UserEntity user = (UserEntity) listEntities.get(0);
        user.setRole((RoleEntity) listEntities.get(1));
        UserEntity saved = userRepository.save(user);
        return composeUserResponse.composeUser(saved);
    }

    private List<Audit> validation(AssignRoleToUserRequest request) {
        Optional<UserEntity> user = userRepository.findById(request.getUserId());
        Optional<RoleEntity> role = roleRepository.findById(request.getRoleId());
        if (!user.isPresent()) {
            throw new UserNotFoundException(ResponseConstant.UserConstant.USER_NOT_FOUND);
        } else if (!role.isPresent()) {
            throw new RoleNotFoundException(ResponseConstant.UserConstant.ROLE);
        } else {
            List<Audit> listEntity = new ArrayList<>();
            listEntity.add(user.get());
            listEntity.add(role.get());
            return listEntity;
        }
    }
}
