package laus.mybatis.eggtrace.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.*;
import org.aspectj.lang.reflect.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EggtraceAroundAnnotationAspect {
	
	private static Logger log = LoggerFactory.getLogger(EggtraceAroundAnnotationAspect.class);

	//@Around("@annotation(laus.mybatis.annotation.EggtraceAround)")
	public Object doAround(ProceedingJoinPoint point) {
		Class<?> cls = point.getTarget().getClass();
		Method method = ((MethodSignature)point.getSignature()).getMethod();
		log.info("arround eggtrace aspect innotation, class:{}, method :{}", cls.getName(), method.getName());
		
		//方法返回结果
        Object result = null;
        @SuppressWarnings("unused")
		Object args = Arrays.asList(point.getArgs());
        try {
            //执行方法（可以在方法前后添加前置和后置通知）
        	log.info("before process method");
            result = point.proceed();
            log.info("end process method");
            //result = validateResult(result);
        } catch (Throwable e) {
        	String err = "method exception：" + e;
            //记录日志
            log.info(err);
            //打印堆栈信息
            e.printStackTrace();
            result = err;
        }
        //返回通知
        return result;
	}
	
	@Before("@annotation(laus.mybatis.annotation.EggtraceAround)")
	public void doBefore(JoinPoint point) {
		Signature method = point.getSignature();
		log.info("Before method({}) processed", method.getName());
	}
	
	@After("@annotation(laus.mybatis.annotation.EggtraceAround)")
	public void doAfter(JoinPoint point) {
		Signature method = point.getSignature();
		log.info("After method({}) processed", method.getName());
	}
}
