package com.greelee.gllog.advice;

import com.alibaba.fastjson.JSON;
import com.greelee.gllog.anno.Action;
import com.greelee.gllog.autoconfiguration.LogProperties;
import com.greelee.gllog.dao.ActionLogDao;
import com.greelee.gllog.model.ActionLogDO;
import gl.tool.util.ip.IpUtil;
import gl.tool.util.secret.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/16
 * @describe: 切面日志
 */
@Aspect
@Slf4j
@Component
public class ActionLogAdvise {


    private LogProperties logProperties;
    private ActionLogDao actionLogDao;
    private HttpServletRequest request;

    @Autowired
    public ActionLogAdvise(LogProperties logProperties,ActionLogDao actionLogDao,HttpServletRequest request){
        this.logProperties = logProperties;
        this.actionLogDao = actionLogDao;
        this.request = request;
    }


    /**
     * 在控制层使用该注解，作为切点
     * @param action
     */
    @Pointcut("@annotation(action)")
    public void actionLogAdvice(Action action){
    }




    /**
     * 环绕通知
     *
     * @param pjp ProceedingJoinPoint接口有一个方法proceed(),用于执行目标方法;该方法的返回值是目标方法的返回值
     * @return 可定义的返回值, 不更改则为目标方法返回值
     */
    @Around(value = "actionLogAdvice(action)", argNames = "pjp,action")
    public Object around(ProceedingJoinPoint pjp, Action action) throws Throwable {
        Object result;
        LocalDateTime start = LocalDateTime.now();
        result = pjp.proceed();
        LocalDateTime end  = LocalDateTime.now();
        Duration duration = Duration.between(start,end);

        ActionLogDO actionLogDO = ActionLogDO.builder()
                .visitTime(start)
                .description(action.describe())
                .duration(duration.toMillis())
                .identify(JwtUtil.getIdentify(request))
                .params(JSON.toJSONString(request.getParameterMap()))
                .ip(IpUtil.getIp(request))
                .url(request.getRequestURI())
                .type(String.valueOf(request.getParameterMap()))
                .createTime(end)
                .build();
        if(logProperties.isEnable()){
            actionLogDao.save(actionLogDO);
        }else {
            log.info(actionLogDO.toString());
        }
        return result;
    }






}
