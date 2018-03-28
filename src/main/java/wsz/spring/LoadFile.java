package wsz.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *获取spring配置文件,2个获取Bean的通用方法
 *@author  wsz
 *@createdTime 2018年3月28日
*/
public class LoadFile {
	
	private static String URL = "spring-aopAuto.xml";
	private static ClassPathXmlApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext(URL);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> T getBean(String beanId) {
		return (T)context.getBean(beanId);
	}
	
	public static <T extends Object> T getBean(Class<T> clazz) {
		return (T)context.getBean(clazz);
	}
	
	public static void main(String[] args) {
		System.out.println(context);
	}
}
