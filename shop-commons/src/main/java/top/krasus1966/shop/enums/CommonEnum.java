package top.krasus1966.shop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用返回值
 *
 * @author Krasus1966
 * @date 2020/8/6 22:31
 **/
@Getter
@AllArgsConstructor
public enum CommonEnum implements ICommonEnum {
    /**
     * 查询返回值
     */
    QUERY_OK(10000, "查询成功"),
    QUERY_ERR(10001, "查询失败"),
    /**
     * 新增返回值
     */
    INSERT_OK(10000,"新增成功"),
    INSERT_ERR(10002,"新增失败"),
    /**
     * 删除返回值
     */
    DELETE_OK(10000,"删除成功"),
    DELETE_ERR(10003,"删除成功"),
    /**
     * 更新返回值
     */
    UPDATE_OK(10000,"更新成功"),
    UPDATE_ERR(10004,"更新失败"),
    ;


    private final Integer code;
    private final String message;
}
