package securityservice.api.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import securityservice.util.constant.ResponseConstant;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse<T> {

    private String code;

    private String message;

    private T content;

    public CommonResponse(T content) {
        this.code = ResponseConstant.SuccessResponse.CODE;
        this.message = ResponseConstant.SuccessResponse.MESSAGE;
        this.content = content;
    }
}
