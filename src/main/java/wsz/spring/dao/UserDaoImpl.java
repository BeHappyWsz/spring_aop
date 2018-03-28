package wsz.spring.dao;

import org.springframework.stereotype.Repository;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月28日
*/
@Repository
public class UserDaoImpl implements UserDao{

	public void say() {
		System.out.println("UserDaoImpl.say()");
	}
	
}
