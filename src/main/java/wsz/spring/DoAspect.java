package wsz.spring;

import wsz.spring.service.UserService;

/**
 *执行、测试
 *注意：手动/自动读取的配置文件分开
 *@author  wsz
 *@createdTime 2018年3月28日
*/
public class DoAspect {

	public static void main (String[] args) throws Exception {
		UserService bean = LoadFile.getBean("userServiceImpl");
//		bean.say();
		bean.testParams("aaa", 45);
	}
}
