package top.krasus1966.shop.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.exception.CustomizeErrorCode;
import top.krasus1966.shop.exception.CustomizeException;

/**
 * 自定义异常处理（服务端）
 * @author Krasus1966
 * @date 2020/7/27 17:48
 **/
@RestControllerAdvice
public class CustomizeControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public CommonResult<CustomizeException> errorHandler(Exception e) {
        if (e instanceof CustomizeException){
            return CommonResult.parse(((CustomizeException) e).getCode(),e.getMessage());
        }else{
            return CommonResult.parse(CustomizeErrorCode.SERVICE_GOT_WRONG);
        }
    }
}
