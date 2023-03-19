package cn.chenmanman.ssm.aop;

import cn.chenmanman.ssm.model.entity.Log;
import cn.chenmanman.ssm.service.LogService;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Slf4j
@Component
public class LogAspect {
    @Autowired
    private LogService logService;

    @Pointcut("execution(* cn.chenmanman.ssm.controller.*.*(..))")
    public void addPointcut(){}

    @Before("addPointcut()")
    public void addLog(JoinPoint joinPoint) throws JsonProcessingException {
        Log loga = new Log();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        loga.setUrl(request.getServletPath());
        loga.setMethod(request.getMethod());
        loga.setController(joinPoint.getSignature().getDeclaringTypeName());
        loga.setUpdateTime(LocalDateTimeUtil.now());

        loga.setIp(request.getHeader("X-Real-Ip") == null ? "127.0.0.1" : request.getHeader("X-Real-Ip"));
        ObjectMapper objectMapper = new ObjectMapper();
        loga.setParam(objectMapper.writeValueAsString(request.getParameterMap()));
        // 输出请求体
        log.info(objectMapper.writeValueAsString(joinPoint.getArgs()));
        logService.addLog(loga);
    }


}
