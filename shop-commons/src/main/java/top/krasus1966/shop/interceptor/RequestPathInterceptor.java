package top.krasus1966.shop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.krasus1966.shop.exception.CommonErrorCode;
import top.krasus1966.shop.exception.CommonException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Krasus1966
 * @date 2020/8/8 21:41
 **/
@Slf4j
public class RequestPathInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            throw new CommonException(CommonErrorCode.PAGE_NOT_FOUND);
        }
        log.info("Method = {} ---- URI = {}", request.getMethod(), request.getRequestURI());
        return true;
    }
}
