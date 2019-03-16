package com.greelee.gllog.manager.impl;

import com.alibaba.fastjson.JSON;
import com.greelee.gllog.autoconfiguration.LogProperties;
import com.greelee.gllog.dao.ExceptionLogDao;
import com.greelee.gllog.manager.ExceptionLogRequest;
import com.greelee.gllog.model.ExceptionLogDO;
import gl.tool.component.exception.ServiceException;
import gl.tool.util.ip.IpUtil;
import gl.tool.util.secret.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/16
 * @describe:
 */
@Component
@Slf4j
public class ExceptionLogRequestImpl implements ExceptionLogRequest {


    @Autowired
    private ExceptionLogDao exceptionLogDao;
    @Autowired
    private LogProperties logProperties;


    /**
     * 保存错误信息
     *
     * @param request
     * @param e
     * @throws ServiceException
     */
    @Override
    public void saveExceptionLog(HttpServletRequest request, Throwable e) throws ServiceException {

        ExceptionLogDO exceptionLogDO = ExceptionLogDO.builder()
                .createTime(LocalDateTime.now())
                .className(e.getClass().getName())
                .identify(JwtUtil.getIdentify(request))
                .ip(IpUtil.getIp(request))
                .message(ExceptionUtils.getMessage(e))
                .params(JSON.toJSONString(request.getParameterMap()))
                .url(request.getRequestURI())
                .stackTrace(ExceptionUtils.getStackTrace(e))
                .build();
        if(logProperties.isEnable()){
            exceptionLogDao.save(exceptionLogDO);
        }else {
            log.error(exceptionLogDO.getMessage(),e);
        }
    }

    /**
     * 错误记录
     * 自定义 message
     *
     * @param request
     * @param msg
     * @param e
     * @throws ServiceException
     */
    @Override
    public void saveExceptionLog(HttpServletRequest request, String msg, Exception e) throws ServiceException {
        ExceptionLogDO exceptionLogDO = ExceptionLogDO.builder()
                .createTime(LocalDateTime.now())
                .className(e.getClass().getName())
                .identify(JwtUtil.getIdentify(request))
                .ip(IpUtil.getIp(request))
                .message(msg)
                .params(JSON.toJSONString(request.getParameterMap()))
                .url(request.getRequestURI())
                .stackTrace(ExceptionUtils.getStackTrace(e))
                .build();
        if(logProperties.isEnable()){
            exceptionLogDao.save(exceptionLogDO);
        }else {
            log.error(msg,e);
        }
    }

    /**
     * 错误记录
     * 自定义 message
     *
     * @param request
     * @param msg
     * @throws ServiceException
     */
    @Override
    public void saveExceptionLog(HttpServletRequest request, String msg) throws ServiceException {
        ExceptionLogDO exceptionLogDO = ExceptionLogDO.builder()
                .createTime(LocalDateTime.now())
                .className("自定义异常")
                .stackTrace("自定义异常")
                .identify(JwtUtil.getIdentify(request))
                .ip(IpUtil.getIp(request))
                .message(msg)
                .params(JSON.toJSONString(request.getParameterMap()))
                .url(request.getRequestURI())
                .build();
        if(logProperties.isEnable()){
            exceptionLogDao.save(exceptionLogDO);
        }else {
            log.error(msg);
        }
    }
}
