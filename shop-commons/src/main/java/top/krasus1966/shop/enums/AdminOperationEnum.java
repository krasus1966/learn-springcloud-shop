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
public enum AdminOperationEnum implements ICustomizeEnum {
    /**
     * 管理员用户登录信息
     */
    ADMIN_LOGIN_ERROR(4001, "用户名或密码不正确"),
    /**
     * 管理员用户登录成功
     */
    ADMIN_LOGIN_RIGHT(2001, "登陆成功");


    private final Integer code;
    private final String message;
}
