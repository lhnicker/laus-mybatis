package laus.mybatis.eggtrace.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import laus.mybatis.annotation.Authentication;
import laus.mybatis.common.JsonException;
import laus.mybatis.common.XmlException;

/**
 * 用户权限认证切面
 * All rights Reserved, Code By LiuHan
 * @Title:     Authentication.java   
 * @Package    laus.mybatis.eggtrace.aop   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午10:08:14   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
@Aspect
@Component
public class AuthenticationAspect {
	
	private static Logger log = LoggerFactory.getLogger(AuthenticationAspect.class);
	
	@Before("@annotation(laus.mybatis.annotation.Authentication)")
	public void doBefore(JoinPoint point) throws NoSuchMethodException, SecurityException, JsonException, XmlException {
		log.info("进入Authentication的切面before逻辑");
		Class<?> curCls = point.getTarget().getClass();
		String methodName = point.getSignature().getName();
		@SuppressWarnings("rawtypes")
		Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
		Method method = curCls.getMethod(methodName, argClass);
		Authentication auth = method.getAnnotation(Authentication.class);
		if(null == auth) {
			//不做处理
		} else {
			boolean needLogin = auth.login();
			if(needLogin) {
				//做需要登录的处理
				//登录逻辑处理
				boolean login = false;
				if(!login) {
					throw new XmlException("尚未登录");
				}
			}
			
			String[] validRoles = auth.allow_roles();
			if(validRoles.length > 0) {
				//做相关的角色验证
				throw new JsonException("您尚未登录");
			}
			
		}
	}

}
