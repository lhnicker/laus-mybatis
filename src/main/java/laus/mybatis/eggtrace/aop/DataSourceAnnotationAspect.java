package laus.mybatis.eggtrace.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import laus.mybatis.annotation.*;
import laus.mybatis.configuration.DataSourceContextHolder;

@Aspect
@Component
public class DataSourceAnnotationAspect {
	
	private final Logger log = LoggerFactory.getLogger(DataSourceAnnotationAspect.class);

	@Before("@annotation(laus.mybatis.annotation.DataSource)")
	public void doBefore(JoinPoint point) {
		String currentDataSource = DataSourceContextHolder.GetCurrentDataSource();
		if(null == currentDataSource || currentDataSource.length() <= 0) 
			currentDataSource = DataSourceContextHolder.DEFAULT_DS;
		log.info("开始切换数据源");
		Class<?> curCls = point.getTarget().getClass();
		String methodName = point.getSignature().getName();
		@SuppressWarnings("rawtypes")
		Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
		try {
			Method method = curCls.getMethod(methodName, argClass);
			//判断当前方法是否存在DataSource注解
			if(method.isAnnotationPresent(DataSource.class)) {
				DataSource dsAnnotation = method.getAnnotation(DataSource.class);
				currentDataSource = dsAnnotation.value();
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		DataSourceContextHolder.SetDataSource(currentDataSource);
		log.info("成功切换数据源");
	}
	
}
