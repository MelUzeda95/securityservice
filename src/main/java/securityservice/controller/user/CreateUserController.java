package securityservice.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.request.user.CreateUserRequest;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.user.CreateUserCommand;
import securityservice.util.constant.ConstantsController;

import javax.validation.Valid;

@Tag(name = ConstantsController.UserTag.NAME, description = ConstantsController.UserTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.USER)
@RestController
@RequestScope
public class CreateUserController {

    private final CreateUserCommand createUserCommand;

    @Autowired
    public CreateUserController(CreateUserCommand createUserCommand) {
        this.createUserCommand = createUserCommand;
    }

    @Operation(summary = "Create new user.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        createUserCommand.setInput(request);
        createUserCommand.execute();
        return new CommonResponse<>(createUserCommand.getOutput());
    }
}
