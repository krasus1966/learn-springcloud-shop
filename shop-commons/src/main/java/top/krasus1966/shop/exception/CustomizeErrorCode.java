package top.krasus1966.shop.exception;

import lombok.Getter;

/**
 * @author Krasus1966
 * @date 2020/7/27 15:09
 **/
@Getter
public enum  CustomizeErrorCode implements ICustomizeErrorCode {
    //页面不存在错误
    PAGE_NOT_FOUND(404,"页面跑丢了"),
    //出现不可预料的错误时进行此提示
    SERVICE_GOT_WRONG(5000,"服务器冒烟了");

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
