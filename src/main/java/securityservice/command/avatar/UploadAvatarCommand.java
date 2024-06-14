package securityservice.command.avatar;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import securityservice.api.request.CommonRequest;
import securityservice.api.request.avatar.UploadAvatarRequest;
import securityservice.api.response.user.UserResponse;
import securityservice.command.AbstractCommand;
import securityservice.exception.ProcessErrorException;
import securityservice.service.avatar.UploadAvatarService;

import java.io.IOException;

@Slf4j
@Service
@Scope(value = "prototype")
public class UploadAvatarCommand extends AbstractCommand {

    @Setter
    private CommonRequest<UploadAvatarRequest> input;

    @Getter
    private UserResponse output;

    private final UploadAvatarService uploadAvatarService;

    private String avatarInBase64;

    @Autowired
    public UploadAvatarCommand(UploadAvatarService uploadAvatarService) {
        this.uploadAvatarService = uploadAvatarService;
    }

    @Override
    protected void preExecute() {
        log.info("UploadAvatarCommand - PreExecute");
        this.avatarInBase64 = convertFileToBase64(input.getContent().getAvatar());
    }

    @Override
    protected void onExecute() {
        log.info("UploadAvatarCommand - OnExecute");
        this.output = uploadAvatarService.upload(input.getId(), avatarInBase64);
    }

    private String convertFileToBase64(MultipartFile file) {
        try {
            return new String(Base64.encodeBase64(file.getBytes()));
        } catch (IOException e) {
            throw new ProcessErrorException("Error convert avatar to base64");
        }
    }
}
