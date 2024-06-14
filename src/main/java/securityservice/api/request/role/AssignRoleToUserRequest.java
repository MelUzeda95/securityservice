package securityservice.api.request.role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AssignRoleToUserRequest {
    private Integer userId;
    private Integer roleId;
}
