package top.krasus1966.shop.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.krasus1966.shop.domain.vo.CommonResult;
import top.krasus1966.shop.exception.CustomizeErrorCode;
import top.krasus1966.shop.exception.CustomizeException;

/**
 * 自定义异常处理（客户端）
 *
 * @author Krasus1966
 * @date 2020/7/27 16:12
 **/
@RestControllerAdvice
@Slf4j
public class CustomizeControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> errorHandler(Exception e) {
        if (e instanceof CustomizeException){
            log.error("服务出现自定义错误,code={},msg={}",((CustomizeException) e).getCode(),e.getMessage());
            return CommonResult.parse(((CustomizeException) e).getCode(),e.getMessage());
        }else{
            log.error("服务出现未知错误", e);
            return CommonResult.parse(CustomizeErrorCode.SERVICE_GOT_WRONG, e.getMessage());
        }
    }
}
