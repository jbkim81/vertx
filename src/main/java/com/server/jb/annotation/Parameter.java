package com.server.jb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.vertx.core.AbstractVerticle;

/**
 * <pre>
 * com.server.jb.annotation
 * Parameter.java
 * </pre>
 * @author	: sol2
 * @Date	: 2019. 7. 15.	
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {
	int index();
	String description() default "";
}
