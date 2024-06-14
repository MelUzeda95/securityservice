package securityservice.service.user;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import securityservice.api.request.user.CreateUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.exception.RoleNotFoundException;
import securityservice.exception.UsernameFoundException;
import securityservice.model.domain.RoleEntity;
import securityservice.model.domain.UserEntity;
import securityservice.model.repository.RoleRepository;
import securityservice.model.repository.UserRepository;
import securityservice.util.constant.ResponseConstant;

import java.util.Optional;

@Service
@Scope(value = "prototype")
public class CreateUserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ComposeUserResponse composeUserResponse;

    public CreateUserService(UserRepository userRepository, RoleRepository roleRepository, ComposeUserResponse composeUserResponse) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.composeUserResponse = composeUserResponse;
    }

    @Transactional
    public UserResponse create(CreateUserRequest request) throws UsernameFoundException {
        if (!usernameExists(request.getUsername())) {
            UserEntity userEntity = composeUser(request);
            UserEntity save = userRepository.save(userEntity);
            UserResponse response = composeUserResponse.composeUser(save);
            return response;
        } else {
            throw new UsernameFoundException(ResponseConstant.UserConstant.USERNAME);
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String emailFormat(String email) {
        return email.toLowerCase();
    }

    private Boolean usernameExists(String username) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private UserEntity composeUser(CreateUserRequest source) {
        UserEntity target = new UserEntity();
        target.setUsername(source.getUsername());
        target.setFirstname(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setRole(findRoleById(source.getRole()));
        return target;
    }

    private RoleEntity findRoleById(Integer id) throws RoleNotFoundException {
        Optional<RoleEntity> roleEntity = roleRepository.findById(id);
        if (roleEntity.isPresent()) {
            return roleEntity.get();
        } else {
            throw new RoleNotFoundException(ResponseConstant.UserConstant.ROLE);
        }
    }
}
