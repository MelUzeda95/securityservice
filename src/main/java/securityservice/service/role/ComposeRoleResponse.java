package securityservice.service.role;


import org.springframework.stereotype.Service;
import securityservice.api.response.role.RoleResponse;
import securityservice.model.domain.RoleEntity;

@Service
public class ComposeRoleResponse {

    public RoleResponse composeRole(RoleEntity source) {
        RoleResponse target = new RoleResponse();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}
