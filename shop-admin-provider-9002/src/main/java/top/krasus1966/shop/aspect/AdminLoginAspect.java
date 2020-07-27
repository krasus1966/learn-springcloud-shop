package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员
 * @author Krasus1966
 * @date 2020/7/26 17:46
 **/
@Aspect
@Component
@Slf4j
public class AdminLoginAspect {

    @Pointcut("execution(public * top.krasus1966.shop.controller.AdminLoginController.toLogin(..))")
    public void pointCut() {
    }

    @AfterReturning(value = "pointCut()",returning = "object")
    public void doBefore(JoinPoint joinPoint,Object object) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();

    }
}
