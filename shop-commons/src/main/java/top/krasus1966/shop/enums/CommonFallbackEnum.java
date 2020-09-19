package top.krasus1966.shop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用异常返回值
 *
 * @author Krasus1966
 * @date 2020/7/28 21:38
 **/
@Getter
@AllArgsConstructor
public enum CommonFallbackEnum implements ICommonEnum {
    /**
     * 服务器降级（限流）
     */
    BLOCK_EXCEPTION_ERROR(5000, "服务器被限流"),
    /**
     * 服务器降级（出现错误）
     */
    FALL_BACK_ERROR(5001, "服务出现致命错误");

    private final Integer code;
    private final String message;
}
