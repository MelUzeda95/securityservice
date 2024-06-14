package securityservice.api.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer role;
}
