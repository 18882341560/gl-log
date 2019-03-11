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
 * @describe: 操作日志记录类
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionLogDO extends PageBean implements Serializable {

    private static final long serialVersionUID = -7390740859814966104L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 类型
     */
    private String type;
    /**
     * 身份(如用户名,手机号,用户 id 等)
     */
    private String identify;
    /**
     * 接口描述
     */
    private String description;
    /**
     * 接口地址
     */
    private String url;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 接口处理时长
     */
    private Long duration;
    /**
     * 访问ip
     */
    private String ip;
    /**
     * 访问时间
     */
    private LocalDateTime visitTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
