package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {

    }
}
