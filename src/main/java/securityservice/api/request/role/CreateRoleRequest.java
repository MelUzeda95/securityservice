package securityservice.api.request.role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleRequest {

    private String name;

    private String description;
}
