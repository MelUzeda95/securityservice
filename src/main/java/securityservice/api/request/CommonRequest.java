package securityservice.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonRequest<T> {

    private Integer id;

    private T content;

}
