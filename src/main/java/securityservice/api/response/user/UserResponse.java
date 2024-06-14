package securityservice.api.response.user;

import lombok.Getter;
import lombok.Setter;
import securityservice.api.response.role.RoleResponse;

@Getter
@Setter
public class UserResponse {

    private Integer id;

    private String fullName;

    private String email;

    private RoleResponse role;
}
