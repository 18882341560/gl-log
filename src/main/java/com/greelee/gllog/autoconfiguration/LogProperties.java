package com.greelee.gllog.autoconfiguration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/11
 * @describe: 日志配置类
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = LogProperties.LOG_PREFIX)
public class LogProperties {

    /**
     * 配置前缀
     */
    public static final String LOG_PREFIX = "gl.log";

    /**
     * 是否记录到数据库,若为 false 则每次打印在 log 中,若为 true 则导入到数据库中
     */
    private boolean enable = false;

}
