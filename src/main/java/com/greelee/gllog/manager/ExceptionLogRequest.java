package com.greelee.gllog.manager;

import com.greelee.gllog.model.ExceptionLogDO;
import gl.tool.component.exception.ServiceException;
import gl.tool.component.mvc.base.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/16
 * @describe:
 */
public interface ExceptionLogRequest extends BaseService<ExceptionLogDO> {
    /**
     * 保存错误信息
     * @param request
     * @param e
     * @throws ServiceException
     */
    void saveExceptionLog(HttpServletRequest request, Throwable e) throws ServiceException;

    /**
     * 错误记录
     * 自定义 message
     * @param request
     * @param msg
     * @param e
     * @throws ServiceException
     */
    void saveExceptionLog(HttpServletRequest request,String msg, Exception e) throws ServiceException;

    /**
     * 错误记录
     * 自定义 message
     * @param request
     * @param msg
     * @throws ServiceException
     */
    void saveExceptionLog(HttpServletRequest request,String msg) throws ServiceException ;
}
