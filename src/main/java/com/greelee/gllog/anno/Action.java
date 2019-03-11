package com.greelee.gllog.anno;

import com.greelee.gllog.constant.ActionLogEnum;

import java.lang.annotation.*;

/**
 * @author: gl
 * @Email: 110.com
 * @version: 1.0
 * @Date: 2019/3/11
 * @describe: 操作日志注解类,用于注解在需要操作日志的接口方法上
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    /**
     * 类型
     */
    ActionLogEnum type();

    /**
     * 描述
     */
    String describe() default "";

}
