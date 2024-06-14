package securityservice.command.user;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.service.user.GetUsersService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@Scope(value = "prototype")
public class GetUsersCommand extends AbstractCommand {

    @Setter
    private List<Integer> input;

    @Getter
    private List<UserResponse> output;

    private final GetUsersService getUsersService;

    public GetUsersCommand(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @Override
    protected void preExecute() {
        log.info("GetUsersCommand - PreExecute");
        this.input = removeDuplicates( input);
    }

    @Override
    protected void onExecute() {
        log.info("GetUsersCommand - OnExecute");
        this.output = getUsersService.findByIds(input);
    }

    private List<Integer> removeDuplicates(List<Integer> userIds) {
        return new ArrayList<>(new HashSet<>(userIds));
    }
}
