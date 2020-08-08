package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Krasus1966
 * @date 2020/8/8 0:18
 **/
@Aspect
@Component
@Slf4j
public class PageAspect {

    @Pointcut(value = "execution(public * top.krasus1966.shop.controller.page.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取URL
        log.info("url={}", request.getRequestURL());

        //获取URI
        log.info("uri={}",request.getRequestURI());

        //获取请求方法
        log.info("method={}", request.getMethod());

        //获取ip地址
        log.info("ip={}", request.getRemoteAddr());

        //获取类和方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //获取参数
        log.info("args={}", joinPoint.getArgs());

    }
}
