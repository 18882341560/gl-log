package com.greelee.gllog.dao;

import com.greelee.gllog.model.ApiLogDO;
import gl.tool.component.mvc.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/12
 * @describe:
 */
@Mapper
public interface ApiLogDao extends BaseDao<ApiLogDO> {
}
