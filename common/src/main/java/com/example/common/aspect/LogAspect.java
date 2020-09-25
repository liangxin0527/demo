package com.example.common.aspect;

import com.example.common.annotation.Log;
import com.example.common.pojo.LoginLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author liang
 * @date 2020/8/26
 */

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@annotation(com.example.common.annotation.Log)")
    public void opLog(){
    };

    @Around("opLog()")
    public void addLog(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        LoginLog loginLog = new LoginLog();
        loginLog.setDescription(signature.getName());
        loginLog.setLoginTime(LocalTime.now());
        loginLog.setMethod(signature.getMethod().getAnnotation(Log.class).name());
    }
}
