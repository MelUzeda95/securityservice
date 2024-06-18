package securityservice.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.user.GetUserCommand;
import securityservice.util.constant.ConstantsController;

@Tag(name = ConstantsController.UserTag.NAME, description = ConstantsController.UserTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.USER)
@RestController
@RequestScope

public class GetUserController {

    private final GetUserCommand getUserCommand;

    @Autowired
    public GetUserController(GetUserCommand getUserCommand) {
        this.getUserCommand = getUserCommand;
    }

    @Operation(summary = "Get user by id.")
    @GetMapping(value = "/{userId}")
    public CommonResponse<UserResponse> getUserById(@PathVariable Integer userId) {
        getUserCommand.setInput(userId);
        getUserCommand.execute();
        return new CommonResponse<>(getUserCommand.getOutput());
    }
}
