package top.krasus1966.shop.exception;

import lombok.Getter;

/**
 * 通用异常处理 代码及信息
 *
 * @author Krasus1966
 * @date 2020/7/27 15:09
 **/
@Getter
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    //页面不存在错误
    PAGE_NOT_FOUND(404, "页面跑丢了"),
    //出现不可预料的错误时进行此提示
    SERVICE_GOT_WRONG(500, "服务器冒烟了");

    private final Integer code;
    private final String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
