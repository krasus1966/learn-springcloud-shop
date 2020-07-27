package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Krasus1966
 * @date 2020/7/26 17:46
 **/
@Aspect
@Component
@Slf4j
public class AdminLoginAspect {

    @Pointcut("execution(public * top.krasus1966.shop.controller.AdminLoginController.toLogin(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void log(JoinPoint joinPoint){
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        log.info("请求的Controller为={}",joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName());
        log.info("请求的IP地址为={}", request != null ? request.getRemoteAddr() : null);
    }
}
