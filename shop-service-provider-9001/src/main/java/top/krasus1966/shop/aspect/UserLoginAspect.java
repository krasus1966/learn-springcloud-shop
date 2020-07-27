package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Krasus1966
 * @date 2020/7/26 17:46
 **/
@Aspect
@Component
@Slf4j
public class UserLoginAspect {

    @Pointcut("execution(public * top.krasus1966.shop.controller.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void log(JoinPoint joinPoint){

    }
}
