package top.krasus1966.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用户登录切面，暂无用途
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
        //增加单点登录的判断登录条件
    }
}
