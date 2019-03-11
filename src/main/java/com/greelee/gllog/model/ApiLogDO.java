package com.greelee.gllog.model;

import gl.tool.component.mvc.base.PageBean;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/11
 * @describe: 使用{HttpUtil#sendGet(String)}{HttpUtil#sendPost(String, List)}向第三方 api 调用时需主动记录
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiLogDO extends PageBean implements Serializable {

    private static final long serialVersionUID = 7738278536762083626L;

    /**
     * 主键id
     */
    private Integer id;
    /**
     * api的地址
     */
    private String url;
    /**
     * 请求方式
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 响应内容
     */
    private String response;
    /**
     * api描述
     */
    private String description;



}
