package com.greelee.gllog.manager.impl;


import com.greelee.gllog.dao.ApiLogDao;
import com.greelee.gllog.manager.ApiLogRequest;
import com.greelee.gllog.model.ApiLogDO;
import gl.tool.component.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/27
 * @describe:
 */
@Component
public class ApiLogRequestImpl implements ApiLogRequest {

    private ApiLogDao apiLogDao;

    @Autowired
    public ApiLogRequestImpl(ApiLogDao apiLogDao) {
        this.apiLogDao = apiLogDao;
    }

    @Override
    public Integer save(ApiLogDO object) throws ServiceException {
        return apiLogDao.save(object);
    }
}
