package wsz.spring;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *使用注解配置切面类
 *1.添加注解@Component
 *@author  wsz
 *@createdTime 2018年3月28日
*/
@Aspect
@Component
public class AspectAuto {
	
	/**
	 * 获取统一的织入信息
	 * @param joinpoint 注意jar包位置
	 */
	public void printMsg(JoinPoint joinpoint) {
		String typeName = joinpoint.getSignature().getDeclaringTypeName();
		String name = joinpoint.getSignature().getName();
		Object[] args = joinpoint.getArgs();
		Object target = joinpoint.getTarget();
		System.out.println("类/接口:"+typeName);
		System.out.println("方法名:"+name);
		System.out.println("方法参数:"+Arrays.toString(args));
		System.out.println("被织入的目标(实现)类:"+target);
	}
	
	@Pointcut("execution(* wsz.spring.service.*.*(..))")
	public void pointCut() {};
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		printMsg(joinPoint);
		System.out.println("AspectAuto.before()");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("AspectAuto.after()");
	}
	
	/**
	 * 获取方法的返回结果;若方法无返回值则为null
	 * @param value
	 */
	@AfterReturning(pointcut="pointCut()", returning="value")
	public void afterReturning(Object value) {
		System.out.println("AspectAuto.afterReturning() value:"+value);
	}
	
	/**
	 * 注意与Around分开测试
	 * @param e
	 */
	@AfterThrowing(pointcut="pointCut()", throwing="e")
	public void afterThrowing(Exception e) {
		System.out.println("AspectAuto.afterThrowing() exception:"+e);
	}
	
	/**
	 * 注意与AfterThrowing分开测试
	 * @param e
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object object = null;
		try {
			System.out.println("around1");
			object = joinPoint.proceed();
			System.out.println("around2:");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
	}
}
