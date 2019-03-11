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
 * @describe: 错误日志记录
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionLogDO extends PageBean implements Serializable {
    private static final long serialVersionUID = 1082472887539687239L;

    /**
     * id主键
     */
    private Integer id;
    /**
     * 用户身份(如用户名,手机号,用户 id 等)
     */
    private String identify;
    /**
     * 访问ip
     */
    private String ip;
    /**
     * 异常请求接口
     */
    private String url;
    /**
     * 异常请求参数,json字符串
     */
    private String params;
    /**
     * 异常类名
     */
    private String className;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 堆栈追述信息
     */
    private String stackTrace;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
