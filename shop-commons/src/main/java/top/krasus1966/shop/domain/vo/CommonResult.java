package top.krasus1966.shop.domain.vo;

import lombok.Data;
import top.krasus1966.shop.enums.ICustomizeEnum;
import top.krasus1966.shop.exception.ICustomizeErrorCode;

import java.io.Serializable;

/**
 * 通用数据展示层对象VO
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

    public static <T> CommonResult<T> parse(Integer code, String msg) {
        return new CommonResult<>(code, msg);
    }

    public static <T> CommonResult<T> parse(Integer code, String msg, T data) {
        return new CommonResult<>(code, msg, data);
    }

    public static <T> CommonResult<T> parse(ICustomizeEnum iCustomizeEnum) {
        return new CommonResult<>(iCustomizeEnum.getCode(), iCustomizeEnum.getMessage());
    }

    public static <T> CommonResult<T> parse(ICustomizeEnum iCustomizeEnum, T data) {
        return new CommonResult<>(iCustomizeEnum.getCode(), iCustomizeEnum.getMessage(), data);
    }

    public static <T> CommonResult<T> parse(ICustomizeErrorCode iCustomizeErrorCode) {
        return new CommonResult<>(iCustomizeErrorCode.getCode(), iCustomizeErrorCode.getMessage());
    }
}
