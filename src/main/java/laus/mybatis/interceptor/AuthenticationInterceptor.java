package laus.mybatis.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import laus.mybatis.annotation.Authentication;;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//将handler强转为HandlerMethod,
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		//从方法处理器中获取出要调用的方法
		Method method = handlerMethod.getMethod();
		//获取出方法上的Authentication注解
		Authentication authenticationAnnotation = method.getAnnotation(Authentication.class);
		if(null == authenticationAnnotation) {
			//如果注解为null,表示不需要拦截，直接通过
			return true;
		}else {
			boolean needLogin = authenticationAnnotation.login();
			if(needLogin) {
				//要求登录，检查用户是否登录
			}
			
			String[] allowRoles = authenticationAnnotation.allow_roles();
			if(allowRoles.length > 0) {
				//有允许角色限制列表，检查用户角色是否符合要求
				
			}
			
			String[] denyRoles = authenticationAnnotation.deny_roles();
			if(denyRoles.length > 0) {
				//有拒绝角色限制列表，检查用户角色是否符合要求
			}
			return true;
		}
	}

}
