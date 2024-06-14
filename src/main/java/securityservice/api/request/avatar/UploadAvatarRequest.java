package securityservice.api.request.avatar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UploadAvatarRequest {

    private MultipartFile avatar;
}
