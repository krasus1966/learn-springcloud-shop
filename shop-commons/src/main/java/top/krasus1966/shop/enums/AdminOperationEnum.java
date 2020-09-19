package top.krasus1966.shop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 管理员操作返回值
 *
 * @author Krasus1966
 * @date 2020/7/27 15:15
 **/
@Getter
@AllArgsConstructor
public enum AdminOperationEnum implements ICommonEnum {
    /**
     * 管理员用户登录失败
     */
    ADMIN_LOGIN_ERROR(10001, "用户名或密码不正确"),
    /**
     * 管理员用户登录成功
     */
    ADMIN_LOGIN_RIGHT(10000, "登陆成功"),
    /**
     * 管理员状态为禁用
     */
    ADMIN_LOCKDOWN(10002,"用户已被禁用，请联系超级管理员"),

    ;


    private final Integer code;
    private final String message;
}
