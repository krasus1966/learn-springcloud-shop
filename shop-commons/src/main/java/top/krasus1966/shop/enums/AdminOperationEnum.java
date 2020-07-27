package top.krasus1966.shop.enums;

import lombok.Getter;

/**
 * @author Krasus1966
 * @date 2020/7/27 15:15
 **/
@Getter
public enum  AdminOperationEnum implements ICustomizeEnum{
    // 管理员用户登录信息
    ADMIN_LOGIN_WRONG(4001,"用户名或密码不正确"),
    //管理员用户登录成功
    ADMIN_LOGIN_RIGHT(2001,"登陆成功");


    private Integer code;
    private String message;

    AdminOperationEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
