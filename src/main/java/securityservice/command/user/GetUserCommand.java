package securityservice.command.user;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.user.GetUserService;

@Slf4j
@Service
@Scope(value = "prototype")
public class GetUserCommand extends AbstractCommand {

    @Setter
    private Integer input;

    @Getter
    private UserResponse output;

    private final GetUserService getUserService;

    @Autowired
    public GetUserCommand(GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    @Override
    protected void onExecute() {
        log.info("GetUserCommand - OnExecute");
        this.output = getUserService.findById(this.input);
    }
}
