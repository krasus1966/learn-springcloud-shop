package top.krasus1966.shop.entity.vo;

import lombok.Data;
import top.krasus1966.shop.enums.ICommonEnum;
import top.krasus1966.shop.exception.ICommonErrorCode;

import java.io.Serializable;

/**
 * 通用数据展示层对象VO
 *
 * @author Krasus1966
 * @date 2020/7/17 22:24
 **/
@Data
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 5652658368574132448L;
    private Integer code;
    private String msg;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 通用返回格式
     *
     * @param code 返回代码
     * @param msg  返回消息
     * @param <T>  空泛型
     * @return {code,msg}
     */
    public static <T> CommonResult<T> parse(Integer code, String msg) {
        return new CommonResult<>(code, msg);
    }

    /**
     * 通用返回格式
     *
     * @param code 返回代码
     * @param msg  返回消息
     * @param data 返回值
     * @param <T>  泛型，返回值类型
     * @return {code,msg,data}
     */
    public static <T> CommonResult<T> parse(Integer code, String msg, T data) {
        return new CommonResult<>(code, msg, data);
    }

    /**
     * 通用返回格式
     *
     * @param iCommonEnum 封装返回消息
     * @param <T>            空泛型
     * @return {code,msg}
     */
    public static <T> CommonResult<T> parse(ICommonEnum iCommonEnum) {
        return new CommonResult<>(iCommonEnum.getCode(), iCommonEnum.getMessage());
    }

    /**
     * 通用返回格式
     *
     * @param iCommonEnum 封装返回消息
     * @param data           返回值
     * @param <T>            泛型，返回值类型
     * @return {code,msg,data}
     */
    public static <T> CommonResult<T> parse(ICommonEnum iCommonEnum, T data) {
        return new CommonResult<>(iCommonEnum.getCode(), iCommonEnum.getMessage(), data);
    }

    /**
     * 通用返回格式 返回通用错误信息 （已废弃）
     *
     * @param iCommonErrorCode 封装错误信息
     * @param <T>                 空泛型
     * @return {code,msg}
     * @deprecated 通用异常处理接口 已废弃
     */
    @Deprecated
    public static <T> CommonResult<T> parse(ICommonErrorCode iCommonErrorCode) {
        return new CommonResult<>(iCommonErrorCode.getCode(), iCommonErrorCode.getMessage());
    }

    /**
     * 通用返回格式 返回通用错误信息 （已废弃）
     *
     * @param iCommonErrorCode 封装错误信息
     * @param data                返回值
     * @param <T>                 泛型，返回值类型
     * @return {code,msg,data}
     * @deprecated 通用异常处理接口 已废弃
     */
    @Deprecated
    public static <T> CommonResult<T> parse(ICommonErrorCode iCommonErrorCode, T data) {
        return new CommonResult<>(iCommonErrorCode.getCode(), iCommonErrorCode.getMessage(), data);
    }
}
