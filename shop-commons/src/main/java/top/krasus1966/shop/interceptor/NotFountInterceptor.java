package top.krasus1966.shop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.krasus1966.shop.exception.CustomizeErrorCode;
import top.krasus1966.shop.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Krasus1966
 * @date 2020/8/8 21:41
 **/
@Slf4j
public class NotFountInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            throw new CustomizeException(CustomizeErrorCode.PAGE_NOT_FOUND);
        }
        log.info("Method = {} ---- URI = {}", request.getMethod(), request.getRequestURI());
        return true;
    }
}
