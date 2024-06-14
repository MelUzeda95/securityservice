package securityservice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securityservice.api.response.user.UserResponse;
import securityservice.model.domain.UserEntity;
import securityservice.service.role.ComposeRoleResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComposeUserResponse {

    private final ComposeRoleResponse composeRoleResponse;

    @Autowired
    public ComposeUserResponse(ComposeRoleResponse composeRoleResponse) {
        this.composeRoleResponse = composeRoleResponse;
    }

    public UserResponse composeUser(UserEntity source) {
        UserResponse target = new UserResponse();
        target.setId(source.getId());
        target.setFullName(source.getFirstname() + " " + source.getLastName());
        target.setEmail(source.getEmail());
        target.setRole(composeRoleResponse.composeRole(source.getRole()));
        return target;
    }

    public List<UserResponse> composeUsers(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::composeUser)
                .collect(Collectors.toList());
    }
}
