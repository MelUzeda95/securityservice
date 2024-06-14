package securityservice.command.user;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.user.LoginUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.user.LoginUserService;

@Slf4j
@Service
@Scope(value = "prototype")
public class LoginUserCommand extends AbstractCommand {

    @Setter
    private LoginUserRequest input;

    @Getter
    private UserResponse output;

    private final LoginUserService loginUserService;

    @Autowired
    public LoginUserCommand(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @Override
    protected void onExecute() {
        log.info("LoginUserCommand - OnExecute");
        this.output = loginUserService.login(this.input);
    }
}
