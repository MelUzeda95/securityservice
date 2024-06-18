package securityservice.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.user.GetUserCommand;
import securityservice.util.constant.ConstantsController;

import java.util.List;

@Tag(name = ConstantsController.UserTag.NAME, description = ConstantsController.UserTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.USER)
@RestController
@RequestScope

public class GetUsersController {

    private final GetUserCommand getUsersCommand;

    public GetUsersController(GetUserCommand getUsersCommand) {
        this.getUsersCommand = getUsersCommand;
    }

    @Operation(summary = "Get users by ids.")
    @GetMapping(value = "/users/{usersIds}")
    public CommonResponse<List<UserResponse>> getUsersByIds(@PathVariable Integer usersIds) {
        getUsersCommand.setInput(usersIds);
        getUsersCommand.execute();
        List<UserResponse> users = getUsersCommand.getOutput();
        return new CommonResponse<>(users);
    }
}
