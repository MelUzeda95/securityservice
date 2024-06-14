package securityservice.command.avatar;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import securityservice.command.AbstractCommand;
import securityservice.service.avatar.GetAvatarService;

@Slf4j
@Service
@Scope(value = "prototype")
public class GetAvatarCommand extends AbstractCommand {

    @Setter
    private Integer input;

    @Getter
    private byte[] output;

    private final GetAvatarService getAvatarService;

    public GetAvatarCommand(GetAvatarService getAvatarService) {
        this.getAvatarService = getAvatarService;
    }


    @Override
    protected void onExecute() {
        log.info("GetAvatarCommand - OnExecute");
        this.output = getAvatarService.findById(this.input);
    }
}
