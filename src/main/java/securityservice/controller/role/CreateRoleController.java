package securityservice.controller.role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.request.role.CreateRoleRequest;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.role.RoleResponse;
import securityservice.command.role.CreateRoleCommand;
import securityservice.util.constant.ConstantsController;

import javax.validation.Valid;


@Tag(name = ConstantsController.RoleTag.NAME, description = ConstantsController.RoleTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.ROLE)
@RestController
@RequestScope
public class CreateRoleController {

    private final CreateRoleCommand createRoleCommand;

    @Autowired
    public CreateRoleController(CreateRoleCommand createRoleCommand) {
        this.createRoleCommand = createRoleCommand;
    }

    @Operation(summary = "Create new role.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<RoleResponse> createRole(@Valid @RequestBody CreateRoleRequest request) {
        createRoleCommand.setInput(request);
        createRoleCommand.execute();
        return new CommonResponse<>(createRoleCommand.getOutput());
    }
}
