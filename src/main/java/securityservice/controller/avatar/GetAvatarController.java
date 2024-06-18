package securityservice.controller.avatar;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import securityservice.command.avatar.GetAvatarCommand;
import securityservice.util.constant.ConstantsController;

@Tag(name = ConstantsController.AvatarTag.NAME, description = ConstantsController.AvatarTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.AVATAR)
@RestController
@RequestScope


public class GetAvatarController {

    private final GetAvatarCommand getAvatarCommand;


    public GetAvatarController(GetAvatarCommand getAvatarCommand) {
        this.getAvatarCommand = getAvatarCommand;
    }

    @Operation(summary = "Get user avatar by id.")
    @GetMapping(value = "/{userId}")
    public ResponseEntity<byte[]> getAvatarById(@PathVariable("userId") Integer userId) {
        getAvatarCommand.setInput(userId);
        getAvatarCommand.execute();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(getAvatarCommand.getOutput(), headers, HttpStatus.OK);
    }
}
