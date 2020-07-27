package top.krasus1966.shop.exception;

import lombok.Getter;

/**
 * @author Krasus1966
 * @date 2020/7/27 15:06
 **/
@Getter
public class CustomizeException extends RuntimeException {
    private Integer code;
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
