package com.example.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * @author liang
 * @date 2020/8/26
 */
@Inherited
@Target(ElementType.METHOD)
@Documented
public @interface Log {

    String value();
    String name();
}
