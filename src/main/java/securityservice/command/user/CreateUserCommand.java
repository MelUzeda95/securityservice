package securityservice.command.user;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.request.user.CreateUserRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.user.CreateUserService;

@Slf4j
@Service
@Scope(value = "prototype")
public class CreateUserCommand extends AbstractCommand {

    @Setter
    private CreateUserRequest input;

    @Getter
    private UserResponse output;

    private final CreateUserService createUserService;

    @Autowired
    public CreateUserCommand(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @Override
    protected void preExecute() {
        log.info("CreateUserCommand - PreExecute");
        this.input.setEmail(createUserService.emailFormat(this.input.getEmail()));
        this.input.setPassword(createUserService.hashPassword(this.input.getPassword()));
    }

    @Override
    protected void onExecute() {
        log.info("CreateUserCommand - OnExecute");
        this.output = createUserService.create(this.input);
    }
}
