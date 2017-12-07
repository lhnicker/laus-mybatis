package laus.mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Authentication {
	/*
	 * 是否要求登录
	 */
	boolean login() default false;
	
	/*
	 * 允许的角色列表
	 */
	String[] allow_roles() default {};
	
	/*
	 * 拒绝的角色列表
	 */
	String[] deny_roles() default{};
}
