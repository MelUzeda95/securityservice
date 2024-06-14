package securityservice.controller.avatar;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import securityservice.api.request.CommonRequest;
import securityservice.api.request.avatar.UploadAvatarRequest;
import securityservice.api.response.CommonResponse;
import securityservice.api.response.user.UserResponse;
import securityservice.command.avatar.UploadAvatarCommand;
import securityservice.util.constant.ConstantsController;

import javax.validation.Valid;

@Tag(name = ConstantsController.AvatarTag.NAME, description = ConstantsController.AvatarTag.DESCRIPTION)
@RequestMapping(value = ConstantsController.BasePath.AVATAR)
@RestController
@RequestScope
public class UploadAvatarController {

    private final UploadAvatarCommand uploadAvatarCommand;

    @Autowired
    public UploadAvatarController(UploadAvatarCommand uploadAvatarCommand) {
        this.uploadAvatarCommand = uploadAvatarCommand;
    }

    @Operation(summary = "Upload a user's avatar")
    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CommonResponse<UserResponse> uploadAvatar(
            @PathVariable("userId") Integer userId,
            @Valid @RequestBody MultipartFile avatar) {
        UploadAvatarRequest uploadAvatar = new UploadAvatarRequest(avatar);
        CommonRequest<UploadAvatarRequest> request = new CommonRequest<>(userId, uploadAvatar);
        uploadAvatarCommand.setInput(request);
        uploadAvatarCommand.execute();
        return new CommonResponse<>(uploadAvatarCommand.getOutput());
    }
}
