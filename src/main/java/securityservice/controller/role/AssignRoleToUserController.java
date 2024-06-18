package securityservice.controller.role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.request.role.AssignRoleToUserRequest;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.role.AssignRoleToUserCommand;
import securityservice.util.constant.ConstantsController;

import jakarta.validation.Valid;

@Tag(name = ConstantsController.RoleTag.NAME, description = ConstantsController.RoleTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.ROLE)
@RestController
@RequestScope

public class AssignRoleToUserController {

    private final AssignRoleToUserCommand assignRoleToUserCommand;

    public AssignRoleToUserController(AssignRoleToUserCommand assignRoleToUserCommand) {
        this.assignRoleToUserCommand = assignRoleToUserCommand;
    }

    @Operation(summary = "Assign role to a user.")
    @PutMapping(value = "/assign")
    public CommonResponse<UserResponse> assignRoleToUser(@Valid @RequestBody AssignRoleToUserRequest request) {
        assignRoleToUserCommand.setInput(request);
        assignRoleToUserCommand.execute();
        return new CommonResponse<>(assignRoleToUserCommand.getOutput());
    }
}
