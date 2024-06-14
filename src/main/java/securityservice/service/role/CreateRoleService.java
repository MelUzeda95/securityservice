package securityservice.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.role.CreateRoleRequest;
import securityservice.api.response.role.RoleResponse;
import securityservice.exception.RoleAlreadyExistsException;
import securityservice.model.domain.RoleEntity;
import securityservice.model.repository.RoleRepository;

import java.util.Optional;

@Service
@Scope(value = "prototype")
public class CreateRoleService {

    private final RoleRepository roleRepository;

    private final ComposeRoleResponse composeRoleResponse;

    @Autowired
    public CreateRoleService(RoleRepository roleRepository, ComposeRoleResponse composeRoleResponse) {
        this.roleRepository = roleRepository;
        this.composeRoleResponse = composeRoleResponse;
    }

    public RoleResponse create(CreateRoleRequest input) {

        Optional<RoleEntity> existingRole = roleRepository.findByName(input.getName());

        if (existingRole.isPresent()) {
            throw new RoleAlreadyExistsException("Role with name " + input.getName() + " already exists.");
        } else {
            RoleEntity newRole = composeRole(input);

            RoleEntity save = roleRepository.save(newRole);

            return composeRoleResponse.composeRole(save);
        }
    }

    private RoleEntity composeRole(CreateRoleRequest source) {
        RoleEntity target = new RoleEntity();
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }
}