package securityservice.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.api.request.user.LoginUserRequest;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.user.LoginUserCommand;
import securityservice.util.constant.ConstantsController;

import javax.validation.Valid;

@Tag(name = ConstantsController.UserTag.NAME, description = ConstantsController.UserTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.USER)
@RestController
@RequestScope
public class LoginUserController {

    private final LoginUserCommand loginUserCommand;

    @Autowired
    public LoginUserController(LoginUserCommand loginUserCommand) {
        this.loginUserCommand = loginUserCommand;
    }

    @Operation(summary = "Login with username and password.")
    @GetMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<UserResponse> loginUser(@Valid @RequestBody LoginUserRequest request) {
        loginUserCommand.setInput(request);
        loginUserCommand.execute();
        return new CommonResponse<>(loginUserCommand.getOutput());
    }
}
