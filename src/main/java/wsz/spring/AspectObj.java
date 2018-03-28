package wsz.spring;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *手动配置文件的切面类
 *@author  wsz
 *@createdTime 2018年3月28日
*/
public class AspectObj {

	/**
	 * 获取统一的织入信息
	 * @param joinpoint
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
	
	/**
	 * 通过JoinPoint,获取连接点的信息.可通过该方法保存日志信息
	 * @param joinpoint 织入增强的连接点,注意引入的包org.aspectj.lang.JoinPoint;
	 */
	public void before(JoinPoint joinpoint) {
		printMsg(joinpoint);
		System.out.println("AspectObj.before()");
	}
	
	public void after(JoinPoint joinpoint) {
		System.out.println("AspectObj.after()");
	}
	
	/**
	 * 方法返回结果.可通过过该方法保存返回结果到日志中
	 * @param value 名称与配置保持一致
	 */
	public void afterReturning(Object value) {
		System.out.println("AspectObj.afterReturning() value:"+value);
	}
	
	/**
	 * 如何触发：不能与around通知一起使用
	 */
	public void afterThrowing(Throwable e) {
		System.out.println("AspectObj.afterThrowing()");
		System.out.println("aaaaa  "+e);
	}
	
	public Object  around(ProceedingJoinPoint joinPoint) {
		Object object = null;
		try {
			System.out.println("around before");
			object = joinPoint.proceed();
			System.out.println("around after");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * around通知传递参数
	 * @param joinPoint
	 * @param username
	 * @param age
	 * @return
	 */
	public Object aroundWithParams(ProceedingJoinPoint joinPoint,String username,int age) {
		Object object = null;
		try {
			System.out.println("aroundWithParams username:"+username+" age:"+age);
			object = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
	}
}
