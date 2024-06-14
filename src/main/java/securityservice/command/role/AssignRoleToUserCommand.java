package securityservice.command.role;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.role.AssignRoleToUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.role.AssignRoleToUserService;

@Slf4j
@Service
@Scope(value = "prototype")
public class AssignRoleToUserCommand extends AbstractCommand {

    @Setter
    private AssignRoleToUserRequest input;

    @Getter
    private UserResponse output;

    private final AssignRoleToUserService assignRoleToUserService;

    public AssignRoleToUserCommand(AssignRoleToUserService assignRoleToUserService) {
        this.assignRoleToUserService = assignRoleToUserService;
    }

    @Override
    protected void onExecute() {
        log.info("AssignRoleToUserCommand - OnExecute");
        this.output = assignRoleToUserService.assignRoleToUser(this.input);
    }
}
