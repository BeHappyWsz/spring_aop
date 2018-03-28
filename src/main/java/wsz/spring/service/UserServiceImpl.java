package wsz.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsz.spring.dao.UserDao;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月28日
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public int say() {
		System.out.print("UserServiceImpl.say()  ");
		userDao.say();
//		System.out.println(1/0); //用于触发AfterThrowing
		return 100;
	}

	/**
	 * 测试around进行传递参数
	 */
	public int testParams(String username,int age) {
		System.out.println(username+" age:"+age);
//		System.out.println(1/0); //用于触发AfterThrowing
		return 11;
	}
}
