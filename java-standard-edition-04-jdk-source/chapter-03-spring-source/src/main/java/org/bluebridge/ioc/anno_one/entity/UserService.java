package org.bluebridge.ioc.anno_one.entity;


import org.bluebridge.ioc.anno_one.anno.Service;

/**
 * @author ronin
 * @date 2019年3月20日  
 */

@Service
public class UserService implements IUserService{

	private UserDao userDao;
	/**
	 * <p>Title: say</p>  
	 * <p>Description: </p>    
	 * @see IUserService#say()
	 */  
	
	public void say() {
		userDao.say();
	}

}
