package securityservice.command.role;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.role.CreateRoleRequest;
import securityservice.api.response.role.RoleResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.role.CreateRoleService;

@Slf4j
@Service
@Scope(value = "prototype")
public class CreateRoleCommand extends AbstractCommand {

    @Setter
    private CreateRoleRequest input;

    @Getter
    private RoleResponse output;

    private final CreateRoleService createRoleService;

    @Autowired
    public CreateRoleCommand(CreateRoleService createRoleService) {
        this.createRoleService = createRoleService;
    }

    @Override
    protected void onExecute() {
        log.info("CreateRoleCommand - OnExecute");
        this.output = createRoleService.create(this.input);
    }
}
