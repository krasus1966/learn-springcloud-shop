package top.krasus1966.shop.exception;

import lombok.Getter;
import top.krasus1966.shop.enums.ICommonEnum;

/**
 * 通用异常处理
 * @author Krasus1966
 * @date 2020/7/27 15:06
 **/
@Getter
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -2844300659641339789L;

    private final Integer code;
    private final String message;

    public CommonException(ICommonEnum errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
